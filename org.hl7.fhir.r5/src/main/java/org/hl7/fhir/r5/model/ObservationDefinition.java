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
 * Set of definitional characteristics for a kind of observation or measurement produced or consumed by an orderable health care service.
 */
@ResourceDef(name="ObservationDefinition", profile="http://hl7.org/fhir/StructureDefinition/ObservationDefinition")
public class ObservationDefinition extends DomainResource {

    public enum ObservationDataType {
        /**
         * A measured amount.
         */
        QUANTITY, 
        /**
         * A coded concept from a reference terminology and/or text.
         */
        CODEABLECONCEPT, 
        /**
         * A sequence of Unicode characters.
         */
        STRING, 
        /**
         * true or false.
         */
        BOOLEAN, 
        /**
         * A signed integer.
         */
        INTEGER, 
        /**
         * A set of values bounded by low and high.
         */
        RANGE, 
        /**
         * A ratio of two Quantity values - a numerator and a denominator.
         */
        RATIO, 
        /**
         * A series of measurements taken by a device.
         */
        SAMPLEDDATA, 
        /**
         * A time during the day, in the format hh:mm:ss.
         */
        TIME, 
        /**
         * A date, date-time or partial date (e.g. just year or year + month) as used in human communication.
         */
        DATETIME, 
        /**
         * A time range defined by start and end date/time.
         */
        PERIOD, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ObservationDataType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Quantity".equals(codeString))
          return QUANTITY;
        if ("CodeableConcept".equals(codeString))
          return CODEABLECONCEPT;
        if ("string".equals(codeString))
          return STRING;
        if ("boolean".equals(codeString))
          return BOOLEAN;
        if ("integer".equals(codeString))
          return INTEGER;
        if ("Range".equals(codeString))
          return RANGE;
        if ("Ratio".equals(codeString))
          return RATIO;
        if ("SampledData".equals(codeString))
          return SAMPLEDDATA;
        if ("time".equals(codeString))
          return TIME;
        if ("dateTime".equals(codeString))
          return DATETIME;
        if ("Period".equals(codeString))
          return PERIOD;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ObservationDataType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case QUANTITY: return "Quantity";
            case CODEABLECONCEPT: return "CodeableConcept";
            case STRING: return "string";
            case BOOLEAN: return "boolean";
            case INTEGER: return "integer";
            case RANGE: return "Range";
            case RATIO: return "Ratio";
            case SAMPLEDDATA: return "SampledData";
            case TIME: return "time";
            case DATETIME: return "dateTime";
            case PERIOD: return "Period";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case QUANTITY: return "http://hl7.org/fhir/permitted-data-type";
            case CODEABLECONCEPT: return "http://hl7.org/fhir/permitted-data-type";
            case STRING: return "http://hl7.org/fhir/permitted-data-type";
            case BOOLEAN: return "http://hl7.org/fhir/permitted-data-type";
            case INTEGER: return "http://hl7.org/fhir/permitted-data-type";
            case RANGE: return "http://hl7.org/fhir/permitted-data-type";
            case RATIO: return "http://hl7.org/fhir/permitted-data-type";
            case SAMPLEDDATA: return "http://hl7.org/fhir/permitted-data-type";
            case TIME: return "http://hl7.org/fhir/permitted-data-type";
            case DATETIME: return "http://hl7.org/fhir/permitted-data-type";
            case PERIOD: return "http://hl7.org/fhir/permitted-data-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case QUANTITY: return "A measured amount.";
            case CODEABLECONCEPT: return "A coded concept from a reference terminology and/or text.";
            case STRING: return "A sequence of Unicode characters.";
            case BOOLEAN: return "true or false.";
            case INTEGER: return "A signed integer.";
            case RANGE: return "A set of values bounded by low and high.";
            case RATIO: return "A ratio of two Quantity values - a numerator and a denominator.";
            case SAMPLEDDATA: return "A series of measurements taken by a device.";
            case TIME: return "A time during the day, in the format hh:mm:ss.";
            case DATETIME: return "A date, date-time or partial date (e.g. just year or year + month) as used in human communication.";
            case PERIOD: return "A time range defined by start and end date/time.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case QUANTITY: return "Quantity";
            case CODEABLECONCEPT: return "CodeableConcept";
            case STRING: return "string";
            case BOOLEAN: return "boolean";
            case INTEGER: return "integer";
            case RANGE: return "Range";
            case RATIO: return "Ratio";
            case SAMPLEDDATA: return "SampledData";
            case TIME: return "time";
            case DATETIME: return "dateTime";
            case PERIOD: return "Period";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ObservationDataTypeEnumFactory implements EnumFactory<ObservationDataType> {
    public ObservationDataType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Quantity".equals(codeString))
          return ObservationDataType.QUANTITY;
        if ("CodeableConcept".equals(codeString))
          return ObservationDataType.CODEABLECONCEPT;
        if ("string".equals(codeString))
          return ObservationDataType.STRING;
        if ("boolean".equals(codeString))
          return ObservationDataType.BOOLEAN;
        if ("integer".equals(codeString))
          return ObservationDataType.INTEGER;
        if ("Range".equals(codeString))
          return ObservationDataType.RANGE;
        if ("Ratio".equals(codeString))
          return ObservationDataType.RATIO;
        if ("SampledData".equals(codeString))
          return ObservationDataType.SAMPLEDDATA;
        if ("time".equals(codeString))
          return ObservationDataType.TIME;
        if ("dateTime".equals(codeString))
          return ObservationDataType.DATETIME;
        if ("Period".equals(codeString))
          return ObservationDataType.PERIOD;
        throw new IllegalArgumentException("Unknown ObservationDataType code '"+codeString+"'");
        }
        public Enumeration<ObservationDataType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ObservationDataType>(this, ObservationDataType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<ObservationDataType>(this, ObservationDataType.NULL, code);
        if ("Quantity".equals(codeString))
          return new Enumeration<ObservationDataType>(this, ObservationDataType.QUANTITY, code);
        if ("CodeableConcept".equals(codeString))
          return new Enumeration<ObservationDataType>(this, ObservationDataType.CODEABLECONCEPT, code);
        if ("string".equals(codeString))
          return new Enumeration<ObservationDataType>(this, ObservationDataType.STRING, code);
        if ("boolean".equals(codeString))
          return new Enumeration<ObservationDataType>(this, ObservationDataType.BOOLEAN, code);
        if ("integer".equals(codeString))
          return new Enumeration<ObservationDataType>(this, ObservationDataType.INTEGER, code);
        if ("Range".equals(codeString))
          return new Enumeration<ObservationDataType>(this, ObservationDataType.RANGE, code);
        if ("Ratio".equals(codeString))
          return new Enumeration<ObservationDataType>(this, ObservationDataType.RATIO, code);
        if ("SampledData".equals(codeString))
          return new Enumeration<ObservationDataType>(this, ObservationDataType.SAMPLEDDATA, code);
        if ("time".equals(codeString))
          return new Enumeration<ObservationDataType>(this, ObservationDataType.TIME, code);
        if ("dateTime".equals(codeString))
          return new Enumeration<ObservationDataType>(this, ObservationDataType.DATETIME, code);
        if ("Period".equals(codeString))
          return new Enumeration<ObservationDataType>(this, ObservationDataType.PERIOD, code);
        throw new FHIRException("Unknown ObservationDataType code '"+codeString+"'");
        }
    public String toCode(ObservationDataType code) {
      if (code == ObservationDataType.QUANTITY)
        return "Quantity";
      if (code == ObservationDataType.CODEABLECONCEPT)
        return "CodeableConcept";
      if (code == ObservationDataType.STRING)
        return "string";
      if (code == ObservationDataType.BOOLEAN)
        return "boolean";
      if (code == ObservationDataType.INTEGER)
        return "integer";
      if (code == ObservationDataType.RANGE)
        return "Range";
      if (code == ObservationDataType.RATIO)
        return "Ratio";
      if (code == ObservationDataType.SAMPLEDDATA)
        return "SampledData";
      if (code == ObservationDataType.TIME)
        return "time";
      if (code == ObservationDataType.DATETIME)
        return "dateTime";
      if (code == ObservationDataType.PERIOD)
        return "Period";
      return "?";
      }
    public String toSystem(ObservationDataType code) {
      return code.getSystem();
      }
    }

    public enum ObservationRangeCategory {
        /**
         * Reference (Normal) Range for Ordinal and Continuous Observations.
         */
        REFERENCE, 
        /**
         * Critical Range for Ordinal and Continuous Observations. Results outside this range are critical.
         */
        CRITICAL, 
        /**
         * Absolute Range for Ordinal and Continuous Observations. Results outside this range are not possible.
         */
        ABSOLUTE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ObservationRangeCategory fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("reference".equals(codeString))
          return REFERENCE;
        if ("critical".equals(codeString))
          return CRITICAL;
        if ("absolute".equals(codeString))
          return ABSOLUTE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ObservationRangeCategory code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case REFERENCE: return "reference";
            case CRITICAL: return "critical";
            case ABSOLUTE: return "absolute";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case REFERENCE: return "http://hl7.org/fhir/observation-range-category";
            case CRITICAL: return "http://hl7.org/fhir/observation-range-category";
            case ABSOLUTE: return "http://hl7.org/fhir/observation-range-category";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case REFERENCE: return "Reference (Normal) Range for Ordinal and Continuous Observations.";
            case CRITICAL: return "Critical Range for Ordinal and Continuous Observations. Results outside this range are critical.";
            case ABSOLUTE: return "Absolute Range for Ordinal and Continuous Observations. Results outside this range are not possible.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case REFERENCE: return "reference range";
            case CRITICAL: return "critical range";
            case ABSOLUTE: return "absolute range";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ObservationRangeCategoryEnumFactory implements EnumFactory<ObservationRangeCategory> {
    public ObservationRangeCategory fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("reference".equals(codeString))
          return ObservationRangeCategory.REFERENCE;
        if ("critical".equals(codeString))
          return ObservationRangeCategory.CRITICAL;
        if ("absolute".equals(codeString))
          return ObservationRangeCategory.ABSOLUTE;
        throw new IllegalArgumentException("Unknown ObservationRangeCategory code '"+codeString+"'");
        }
        public Enumeration<ObservationRangeCategory> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ObservationRangeCategory>(this, ObservationRangeCategory.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<ObservationRangeCategory>(this, ObservationRangeCategory.NULL, code);
        if ("reference".equals(codeString))
          return new Enumeration<ObservationRangeCategory>(this, ObservationRangeCategory.REFERENCE, code);
        if ("critical".equals(codeString))
          return new Enumeration<ObservationRangeCategory>(this, ObservationRangeCategory.CRITICAL, code);
        if ("absolute".equals(codeString))
          return new Enumeration<ObservationRangeCategory>(this, ObservationRangeCategory.ABSOLUTE, code);
        throw new FHIRException("Unknown ObservationRangeCategory code '"+codeString+"'");
        }
    public String toCode(ObservationRangeCategory code) {
      if (code == ObservationRangeCategory.REFERENCE)
        return "reference";
      if (code == ObservationRangeCategory.CRITICAL)
        return "critical";
      if (code == ObservationRangeCategory.ABSOLUTE)
        return "absolute";
      return "?";
      }
    public String toSystem(ObservationRangeCategory code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class ObservationDefinitionQuantitativeDetailsComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Primary unit used to report quantitative results of observations conforming to this ObservationDefinition.
         */
        @Child(name = "unit", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Primary unit for quantitative results", formalDefinition="Primary unit used to report quantitative results of observations conforming to this ObservationDefinition." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/ucum-units")
        protected CodeableConcept unit;

        /**
         * Secondary unit used to report quantitative results of observations conforming to this ObservationDefinition.
         */
        @Child(name = "customaryUnit", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Customary (secondary) unit for quantitative results", formalDefinition="Secondary unit used to report quantitative results of observations conforming to this ObservationDefinition." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/ucum-units")
        protected CodeableConcept customaryUnit;

        /**
         * Factor for converting value expressed with primary unit to value expressed with secondary unit.
         */
        @Child(name = "conversionFactor", type = {DecimalType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Primary to secondary unit conversion factor", formalDefinition="Factor for converting value expressed with primary unit to value expressed with secondary unit." )
        protected DecimalType conversionFactor;

        /**
         * Number of digits after decimal separator when the results of such observations are of type Quantity.
         */
        @Child(name = "decimalPrecision", type = {IntegerType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Decimal precision of observation quantitative results", formalDefinition="Number of digits after decimal separator when the results of such observations are of type Quantity." )
        protected IntegerType decimalPrecision;

        private static final long serialVersionUID = -1745187850L;

    /**
     * Constructor
     */
      public ObservationDefinitionQuantitativeDetailsComponent() {
        super();
      }

        /**
         * @return {@link #unit} (Primary unit used to report quantitative results of observations conforming to this ObservationDefinition.)
         */
        public CodeableConcept getUnit() { 
          if (this.unit == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationDefinitionQuantitativeDetailsComponent.unit");
            else if (Configuration.doAutoCreate())
              this.unit = new CodeableConcept(); // cc
          return this.unit;
        }

        public boolean hasUnit() { 
          return this.unit != null && !this.unit.isEmpty();
        }

        /**
         * @param value {@link #unit} (Primary unit used to report quantitative results of observations conforming to this ObservationDefinition.)
         */
        public ObservationDefinitionQuantitativeDetailsComponent setUnit(CodeableConcept value) { 
          this.unit = value;
          return this;
        }

        /**
         * @return {@link #customaryUnit} (Secondary unit used to report quantitative results of observations conforming to this ObservationDefinition.)
         */
        public CodeableConcept getCustomaryUnit() { 
          if (this.customaryUnit == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationDefinitionQuantitativeDetailsComponent.customaryUnit");
            else if (Configuration.doAutoCreate())
              this.customaryUnit = new CodeableConcept(); // cc
          return this.customaryUnit;
        }

        public boolean hasCustomaryUnit() { 
          return this.customaryUnit != null && !this.customaryUnit.isEmpty();
        }

        /**
         * @param value {@link #customaryUnit} (Secondary unit used to report quantitative results of observations conforming to this ObservationDefinition.)
         */
        public ObservationDefinitionQuantitativeDetailsComponent setCustomaryUnit(CodeableConcept value) { 
          this.customaryUnit = value;
          return this;
        }

        /**
         * @return {@link #conversionFactor} (Factor for converting value expressed with primary unit to value expressed with secondary unit.). This is the underlying object with id, value and extensions. The accessor "getConversionFactor" gives direct access to the value
         */
        public DecimalType getConversionFactorElement() { 
          if (this.conversionFactor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationDefinitionQuantitativeDetailsComponent.conversionFactor");
            else if (Configuration.doAutoCreate())
              this.conversionFactor = new DecimalType(); // bb
          return this.conversionFactor;
        }

        public boolean hasConversionFactorElement() { 
          return this.conversionFactor != null && !this.conversionFactor.isEmpty();
        }

        public boolean hasConversionFactor() { 
          return this.conversionFactor != null && !this.conversionFactor.isEmpty();
        }

        /**
         * @param value {@link #conversionFactor} (Factor for converting value expressed with primary unit to value expressed with secondary unit.). This is the underlying object with id, value and extensions. The accessor "getConversionFactor" gives direct access to the value
         */
        public ObservationDefinitionQuantitativeDetailsComponent setConversionFactorElement(DecimalType value) { 
          this.conversionFactor = value;
          return this;
        }

        /**
         * @return Factor for converting value expressed with primary unit to value expressed with secondary unit.
         */
        public BigDecimal getConversionFactor() { 
          return this.conversionFactor == null ? null : this.conversionFactor.getValue();
        }

        /**
         * @param value Factor for converting value expressed with primary unit to value expressed with secondary unit.
         */
        public ObservationDefinitionQuantitativeDetailsComponent setConversionFactor(BigDecimal value) { 
          if (value == null)
            this.conversionFactor = null;
          else {
            if (this.conversionFactor == null)
              this.conversionFactor = new DecimalType();
            this.conversionFactor.setValue(value);
          }
          return this;
        }

        /**
         * @param value Factor for converting value expressed with primary unit to value expressed with secondary unit.
         */
        public ObservationDefinitionQuantitativeDetailsComponent setConversionFactor(long value) { 
              this.conversionFactor = new DecimalType();
            this.conversionFactor.setValue(value);
          return this;
        }

        /**
         * @param value Factor for converting value expressed with primary unit to value expressed with secondary unit.
         */
        public ObservationDefinitionQuantitativeDetailsComponent setConversionFactor(double value) { 
              this.conversionFactor = new DecimalType();
            this.conversionFactor.setValue(value);
          return this;
        }

        /**
         * @return {@link #decimalPrecision} (Number of digits after decimal separator when the results of such observations are of type Quantity.). This is the underlying object with id, value and extensions. The accessor "getDecimalPrecision" gives direct access to the value
         */
        public IntegerType getDecimalPrecisionElement() { 
          if (this.decimalPrecision == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationDefinitionQuantitativeDetailsComponent.decimalPrecision");
            else if (Configuration.doAutoCreate())
              this.decimalPrecision = new IntegerType(); // bb
          return this.decimalPrecision;
        }

        public boolean hasDecimalPrecisionElement() { 
          return this.decimalPrecision != null && !this.decimalPrecision.isEmpty();
        }

        public boolean hasDecimalPrecision() { 
          return this.decimalPrecision != null && !this.decimalPrecision.isEmpty();
        }

        /**
         * @param value {@link #decimalPrecision} (Number of digits after decimal separator when the results of such observations are of type Quantity.). This is the underlying object with id, value and extensions. The accessor "getDecimalPrecision" gives direct access to the value
         */
        public ObservationDefinitionQuantitativeDetailsComponent setDecimalPrecisionElement(IntegerType value) { 
          this.decimalPrecision = value;
          return this;
        }

        /**
         * @return Number of digits after decimal separator when the results of such observations are of type Quantity.
         */
        public int getDecimalPrecision() { 
          return this.decimalPrecision == null || this.decimalPrecision.isEmpty() ? 0 : this.decimalPrecision.getValue();
        }

        /**
         * @param value Number of digits after decimal separator when the results of such observations are of type Quantity.
         */
        public ObservationDefinitionQuantitativeDetailsComponent setDecimalPrecision(int value) { 
            if (this.decimalPrecision == null)
              this.decimalPrecision = new IntegerType();
            this.decimalPrecision.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("unit", "CodeableConcept", "Primary unit used to report quantitative results of observations conforming to this ObservationDefinition.", 0, 1, unit));
          children.add(new Property("customaryUnit", "CodeableConcept", "Secondary unit used to report quantitative results of observations conforming to this ObservationDefinition.", 0, 1, customaryUnit));
          children.add(new Property("conversionFactor", "decimal", "Factor for converting value expressed with primary unit to value expressed with secondary unit.", 0, 1, conversionFactor));
          children.add(new Property("decimalPrecision", "integer", "Number of digits after decimal separator when the results of such observations are of type Quantity.", 0, 1, decimalPrecision));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3594628: /*unit*/  return new Property("unit", "CodeableConcept", "Primary unit used to report quantitative results of observations conforming to this ObservationDefinition.", 0, 1, unit);
          case -1375586437: /*customaryUnit*/  return new Property("customaryUnit", "CodeableConcept", "Secondary unit used to report quantitative results of observations conforming to this ObservationDefinition.", 0, 1, customaryUnit);
          case 1438876165: /*conversionFactor*/  return new Property("conversionFactor", "decimal", "Factor for converting value expressed with primary unit to value expressed with secondary unit.", 0, 1, conversionFactor);
          case -1564447699: /*decimalPrecision*/  return new Property("decimalPrecision", "integer", "Number of digits after decimal separator when the results of such observations are of type Quantity.", 0, 1, decimalPrecision);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3594628: /*unit*/ return this.unit == null ? new Base[0] : new Base[] {this.unit}; // CodeableConcept
        case -1375586437: /*customaryUnit*/ return this.customaryUnit == null ? new Base[0] : new Base[] {this.customaryUnit}; // CodeableConcept
        case 1438876165: /*conversionFactor*/ return this.conversionFactor == null ? new Base[0] : new Base[] {this.conversionFactor}; // DecimalType
        case -1564447699: /*decimalPrecision*/ return this.decimalPrecision == null ? new Base[0] : new Base[] {this.decimalPrecision}; // IntegerType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3594628: // unit
          this.unit = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1375586437: // customaryUnit
          this.customaryUnit = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1438876165: // conversionFactor
          this.conversionFactor = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case -1564447699: // decimalPrecision
          this.decimalPrecision = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("unit")) {
          this.unit = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("customaryUnit")) {
          this.customaryUnit = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("conversionFactor")) {
          this.conversionFactor = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("decimalPrecision")) {
          this.decimalPrecision = TypeConvertor.castToInteger(value); // IntegerType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3594628:  return getUnit();
        case -1375586437:  return getCustomaryUnit();
        case 1438876165:  return getConversionFactorElement();
        case -1564447699:  return getDecimalPrecisionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3594628: /*unit*/ return new String[] {"CodeableConcept"};
        case -1375586437: /*customaryUnit*/ return new String[] {"CodeableConcept"};
        case 1438876165: /*conversionFactor*/ return new String[] {"decimal"};
        case -1564447699: /*decimalPrecision*/ return new String[] {"integer"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("unit")) {
          this.unit = new CodeableConcept();
          return this.unit;
        }
        else if (name.equals("customaryUnit")) {
          this.customaryUnit = new CodeableConcept();
          return this.customaryUnit;
        }
        else if (name.equals("conversionFactor")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.quantitativeDetails.conversionFactor");
        }
        else if (name.equals("decimalPrecision")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.quantitativeDetails.decimalPrecision");
        }
        else
          return super.addChild(name);
      }

      public ObservationDefinitionQuantitativeDetailsComponent copy() {
        ObservationDefinitionQuantitativeDetailsComponent dst = new ObservationDefinitionQuantitativeDetailsComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ObservationDefinitionQuantitativeDetailsComponent dst) {
        super.copyValues(dst);
        dst.unit = unit == null ? null : unit.copy();
        dst.customaryUnit = customaryUnit == null ? null : customaryUnit.copy();
        dst.conversionFactor = conversionFactor == null ? null : conversionFactor.copy();
        dst.decimalPrecision = decimalPrecision == null ? null : decimalPrecision.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ObservationDefinitionQuantitativeDetailsComponent))
          return false;
        ObservationDefinitionQuantitativeDetailsComponent o = (ObservationDefinitionQuantitativeDetailsComponent) other_;
        return compareDeep(unit, o.unit, true) && compareDeep(customaryUnit, o.customaryUnit, true) && compareDeep(conversionFactor, o.conversionFactor, true)
           && compareDeep(decimalPrecision, o.decimalPrecision, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ObservationDefinitionQuantitativeDetailsComponent))
          return false;
        ObservationDefinitionQuantitativeDetailsComponent o = (ObservationDefinitionQuantitativeDetailsComponent) other_;
        return compareValues(conversionFactor, o.conversionFactor, true) && compareValues(decimalPrecision, o.decimalPrecision, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(unit, customaryUnit, conversionFactor
          , decimalPrecision);
      }

  public String fhirType() {
    return "ObservationDefinition.quantitativeDetails";

  }

  }

    @Block()
    public static class ObservationDefinitionQualifiedValueComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A concept defining the context for this set of qualified values.
         */
        @Child(name = "context", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Context qualifier for the set of qualified values", formalDefinition="A concept defining the context for this set of qualified values." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/referencerange-meaning")
        protected CodeableConcept context;

        /**
         * The target population this  set of qualified values applies to.
         */
        @Child(name = "appliesTo", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Targetted population for the set of qualified values", formalDefinition="The target population this  set of qualified values applies to." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/referencerange-appliesto")
        protected List<CodeableConcept> appliesTo;

        /**
         * The gender this  set of qualified values applies to.
         */
        @Child(name = "gender", type = {CodeType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="male | female | other | unknown", formalDefinition="The gender this  set of qualified values applies to." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/administrative-gender")
        protected Enumeration<AdministrativeGender> gender;

        /**
         * The age range this  set of qualified values applies to.
         */
        @Child(name = "age", type = {Range.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Applicable age range for the set of qualified values", formalDefinition="The age range this  set of qualified values applies to." )
        protected Range age;

        /**
         * The gestational age this  set of qualified values applies to.
         */
        @Child(name = "gestationalAge", type = {Range.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Applicable gestational age range for the set of qualified values", formalDefinition="The gestational age this  set of qualified values applies to." )
        protected Range gestationalAge;

        /**
         * Text based condition for which the the set of qualified values is valid.
         */
        @Child(name = "condition", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Condition associated with the set of qualified values", formalDefinition="Text based condition for which the the set of qualified values is valid." )
        protected StringType condition;

        /**
         * The category of range of values for continuous or ordinal observations that match the criteria of this set of qualified values.
         */
        @Child(name = "rangeCategory", type = {CodeType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="reference | critical | absolute", formalDefinition="The category of range of values for continuous or ordinal observations that match the criteria of this set of qualified values." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-range-category")
        protected Enumeration<ObservationRangeCategory> rangeCategory;

        /**
         * The range of values defined for continuous or ordinal observations that match the criteria of this set of qualified values.
         */
        @Child(name = "range", type = {Range.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The range for continuous or ordinal observations", formalDefinition="The range of values defined for continuous or ordinal observations that match the criteria of this set of qualified values." )
        protected Range range;

        /**
         * The set of valid coded results for qualitative observations  that match the criteria of this set of qualified values.
         */
        @Child(name = "validCodedValueSet", type = {CanonicalType.class}, order=9, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Value set of valid coded values as part of this set of qualified values", formalDefinition="The set of valid coded results for qualitative observations  that match the criteria of this set of qualified values." )
        protected CanonicalType validCodedValueSet;

        /**
         * The set of normal coded results for qualitative observations  that match the criteria of this set of qualified values.
         */
        @Child(name = "normalCodedValueSet", type = {CanonicalType.class}, order=10, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Value set of normal coded values as part of this set of qualified values", formalDefinition="The set of normal coded results for qualitative observations  that match the criteria of this set of qualified values." )
        protected CanonicalType normalCodedValueSet;

        /**
         * The set of abnormal coded results for qualitative observations  that match the criteria of this set of qualified values.
         */
        @Child(name = "abnormalCodedValueSet", type = {CanonicalType.class}, order=11, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Value set of abnormal coded values as part of this set of qualified values", formalDefinition="The set of abnormal coded results for qualitative observations  that match the criteria of this set of qualified values." )
        protected CanonicalType abnormalCodedValueSet;

        /**
         * The set of critical coded results for qualitative observations  that match the criteria of this set of qualified values.
         */
        @Child(name = "criticalCodedValueSet", type = {CanonicalType.class}, order=12, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Value set of critical coded values as part of this set of qualified values", formalDefinition="The set of critical coded results for qualitative observations  that match the criteria of this set of qualified values." )
        protected CanonicalType criticalCodedValueSet;

        private static final long serialVersionUID = -538666361L;

    /**
     * Constructor
     */
      public ObservationDefinitionQualifiedValueComponent() {
        super();
      }

        /**
         * @return {@link #context} (A concept defining the context for this set of qualified values.)
         */
        public CodeableConcept getContext() { 
          if (this.context == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationDefinitionQualifiedValueComponent.context");
            else if (Configuration.doAutoCreate())
              this.context = new CodeableConcept(); // cc
          return this.context;
        }

        public boolean hasContext() { 
          return this.context != null && !this.context.isEmpty();
        }

        /**
         * @param value {@link #context} (A concept defining the context for this set of qualified values.)
         */
        public ObservationDefinitionQualifiedValueComponent setContext(CodeableConcept value) { 
          this.context = value;
          return this;
        }

        /**
         * @return {@link #appliesTo} (The target population this  set of qualified values applies to.)
         */
        public List<CodeableConcept> getAppliesTo() { 
          if (this.appliesTo == null)
            this.appliesTo = new ArrayList<CodeableConcept>();
          return this.appliesTo;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ObservationDefinitionQualifiedValueComponent setAppliesTo(List<CodeableConcept> theAppliesTo) { 
          this.appliesTo = theAppliesTo;
          return this;
        }

        public boolean hasAppliesTo() { 
          if (this.appliesTo == null)
            return false;
          for (CodeableConcept item : this.appliesTo)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addAppliesTo() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.appliesTo == null)
            this.appliesTo = new ArrayList<CodeableConcept>();
          this.appliesTo.add(t);
          return t;
        }

        public ObservationDefinitionQualifiedValueComponent addAppliesTo(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.appliesTo == null)
            this.appliesTo = new ArrayList<CodeableConcept>();
          this.appliesTo.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #appliesTo}, creating it if it does not already exist {3}
         */
        public CodeableConcept getAppliesToFirstRep() { 
          if (getAppliesTo().isEmpty()) {
            addAppliesTo();
          }
          return getAppliesTo().get(0);
        }

        /**
         * @return {@link #gender} (The gender this  set of qualified values applies to.). This is the underlying object with id, value and extensions. The accessor "getGender" gives direct access to the value
         */
        public Enumeration<AdministrativeGender> getGenderElement() { 
          if (this.gender == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationDefinitionQualifiedValueComponent.gender");
            else if (Configuration.doAutoCreate())
              this.gender = new Enumeration<AdministrativeGender>(new AdministrativeGenderEnumFactory()); // bb
          return this.gender;
        }

        public boolean hasGenderElement() { 
          return this.gender != null && !this.gender.isEmpty();
        }

        public boolean hasGender() { 
          return this.gender != null && !this.gender.isEmpty();
        }

        /**
         * @param value {@link #gender} (The gender this  set of qualified values applies to.). This is the underlying object with id, value and extensions. The accessor "getGender" gives direct access to the value
         */
        public ObservationDefinitionQualifiedValueComponent setGenderElement(Enumeration<AdministrativeGender> value) { 
          this.gender = value;
          return this;
        }

        /**
         * @return The gender this  set of qualified values applies to.
         */
        public AdministrativeGender getGender() { 
          return this.gender == null ? null : this.gender.getValue();
        }

        /**
         * @param value The gender this  set of qualified values applies to.
         */
        public ObservationDefinitionQualifiedValueComponent setGender(AdministrativeGender value) { 
          if (value == null)
            this.gender = null;
          else {
            if (this.gender == null)
              this.gender = new Enumeration<AdministrativeGender>(new AdministrativeGenderEnumFactory());
            this.gender.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #age} (The age range this  set of qualified values applies to.)
         */
        public Range getAge() { 
          if (this.age == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationDefinitionQualifiedValueComponent.age");
            else if (Configuration.doAutoCreate())
              this.age = new Range(); // cc
          return this.age;
        }

        public boolean hasAge() { 
          return this.age != null && !this.age.isEmpty();
        }

        /**
         * @param value {@link #age} (The age range this  set of qualified values applies to.)
         */
        public ObservationDefinitionQualifiedValueComponent setAge(Range value) { 
          this.age = value;
          return this;
        }

        /**
         * @return {@link #gestationalAge} (The gestational age this  set of qualified values applies to.)
         */
        public Range getGestationalAge() { 
          if (this.gestationalAge == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationDefinitionQualifiedValueComponent.gestationalAge");
            else if (Configuration.doAutoCreate())
              this.gestationalAge = new Range(); // cc
          return this.gestationalAge;
        }

        public boolean hasGestationalAge() { 
          return this.gestationalAge != null && !this.gestationalAge.isEmpty();
        }

        /**
         * @param value {@link #gestationalAge} (The gestational age this  set of qualified values applies to.)
         */
        public ObservationDefinitionQualifiedValueComponent setGestationalAge(Range value) { 
          this.gestationalAge = value;
          return this;
        }

        /**
         * @return {@link #condition} (Text based condition for which the the set of qualified values is valid.). This is the underlying object with id, value and extensions. The accessor "getCondition" gives direct access to the value
         */
        public StringType getConditionElement() { 
          if (this.condition == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationDefinitionQualifiedValueComponent.condition");
            else if (Configuration.doAutoCreate())
              this.condition = new StringType(); // bb
          return this.condition;
        }

        public boolean hasConditionElement() { 
          return this.condition != null && !this.condition.isEmpty();
        }

        public boolean hasCondition() { 
          return this.condition != null && !this.condition.isEmpty();
        }

        /**
         * @param value {@link #condition} (Text based condition for which the the set of qualified values is valid.). This is the underlying object with id, value and extensions. The accessor "getCondition" gives direct access to the value
         */
        public ObservationDefinitionQualifiedValueComponent setConditionElement(StringType value) { 
          this.condition = value;
          return this;
        }

        /**
         * @return Text based condition for which the the set of qualified values is valid.
         */
        public String getCondition() { 
          return this.condition == null ? null : this.condition.getValue();
        }

        /**
         * @param value Text based condition for which the the set of qualified values is valid.
         */
        public ObservationDefinitionQualifiedValueComponent setCondition(String value) { 
          if (Utilities.noString(value))
            this.condition = null;
          else {
            if (this.condition == null)
              this.condition = new StringType();
            this.condition.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #rangeCategory} (The category of range of values for continuous or ordinal observations that match the criteria of this set of qualified values.). This is the underlying object with id, value and extensions. The accessor "getRangeCategory" gives direct access to the value
         */
        public Enumeration<ObservationRangeCategory> getRangeCategoryElement() { 
          if (this.rangeCategory == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationDefinitionQualifiedValueComponent.rangeCategory");
            else if (Configuration.doAutoCreate())
              this.rangeCategory = new Enumeration<ObservationRangeCategory>(new ObservationRangeCategoryEnumFactory()); // bb
          return this.rangeCategory;
        }

        public boolean hasRangeCategoryElement() { 
          return this.rangeCategory != null && !this.rangeCategory.isEmpty();
        }

        public boolean hasRangeCategory() { 
          return this.rangeCategory != null && !this.rangeCategory.isEmpty();
        }

        /**
         * @param value {@link #rangeCategory} (The category of range of values for continuous or ordinal observations that match the criteria of this set of qualified values.). This is the underlying object with id, value and extensions. The accessor "getRangeCategory" gives direct access to the value
         */
        public ObservationDefinitionQualifiedValueComponent setRangeCategoryElement(Enumeration<ObservationRangeCategory> value) { 
          this.rangeCategory = value;
          return this;
        }

        /**
         * @return The category of range of values for continuous or ordinal observations that match the criteria of this set of qualified values.
         */
        public ObservationRangeCategory getRangeCategory() { 
          return this.rangeCategory == null ? null : this.rangeCategory.getValue();
        }

        /**
         * @param value The category of range of values for continuous or ordinal observations that match the criteria of this set of qualified values.
         */
        public ObservationDefinitionQualifiedValueComponent setRangeCategory(ObservationRangeCategory value) { 
          if (value == null)
            this.rangeCategory = null;
          else {
            if (this.rangeCategory == null)
              this.rangeCategory = new Enumeration<ObservationRangeCategory>(new ObservationRangeCategoryEnumFactory());
            this.rangeCategory.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #range} (The range of values defined for continuous or ordinal observations that match the criteria of this set of qualified values.)
         */
        public Range getRange() { 
          if (this.range == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationDefinitionQualifiedValueComponent.range");
            else if (Configuration.doAutoCreate())
              this.range = new Range(); // cc
          return this.range;
        }

        public boolean hasRange() { 
          return this.range != null && !this.range.isEmpty();
        }

        /**
         * @param value {@link #range} (The range of values defined for continuous or ordinal observations that match the criteria of this set of qualified values.)
         */
        public ObservationDefinitionQualifiedValueComponent setRange(Range value) { 
          this.range = value;
          return this;
        }

        /**
         * @return {@link #validCodedValueSet} (The set of valid coded results for qualitative observations  that match the criteria of this set of qualified values.). This is the underlying object with id, value and extensions. The accessor "getValidCodedValueSet" gives direct access to the value
         */
        public CanonicalType getValidCodedValueSetElement() { 
          if (this.validCodedValueSet == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationDefinitionQualifiedValueComponent.validCodedValueSet");
            else if (Configuration.doAutoCreate())
              this.validCodedValueSet = new CanonicalType(); // bb
          return this.validCodedValueSet;
        }

        public boolean hasValidCodedValueSetElement() { 
          return this.validCodedValueSet != null && !this.validCodedValueSet.isEmpty();
        }

        public boolean hasValidCodedValueSet() { 
          return this.validCodedValueSet != null && !this.validCodedValueSet.isEmpty();
        }

        /**
         * @param value {@link #validCodedValueSet} (The set of valid coded results for qualitative observations  that match the criteria of this set of qualified values.). This is the underlying object with id, value and extensions. The accessor "getValidCodedValueSet" gives direct access to the value
         */
        public ObservationDefinitionQualifiedValueComponent setValidCodedValueSetElement(CanonicalType value) { 
          this.validCodedValueSet = value;
          return this;
        }

        /**
         * @return The set of valid coded results for qualitative observations  that match the criteria of this set of qualified values.
         */
        public String getValidCodedValueSet() { 
          return this.validCodedValueSet == null ? null : this.validCodedValueSet.getValue();
        }

        /**
         * @param value The set of valid coded results for qualitative observations  that match the criteria of this set of qualified values.
         */
        public ObservationDefinitionQualifiedValueComponent setValidCodedValueSet(String value) { 
          if (Utilities.noString(value))
            this.validCodedValueSet = null;
          else {
            if (this.validCodedValueSet == null)
              this.validCodedValueSet = new CanonicalType();
            this.validCodedValueSet.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #normalCodedValueSet} (The set of normal coded results for qualitative observations  that match the criteria of this set of qualified values.). This is the underlying object with id, value and extensions. The accessor "getNormalCodedValueSet" gives direct access to the value
         */
        public CanonicalType getNormalCodedValueSetElement() { 
          if (this.normalCodedValueSet == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationDefinitionQualifiedValueComponent.normalCodedValueSet");
            else if (Configuration.doAutoCreate())
              this.normalCodedValueSet = new CanonicalType(); // bb
          return this.normalCodedValueSet;
        }

        public boolean hasNormalCodedValueSetElement() { 
          return this.normalCodedValueSet != null && !this.normalCodedValueSet.isEmpty();
        }

        public boolean hasNormalCodedValueSet() { 
          return this.normalCodedValueSet != null && !this.normalCodedValueSet.isEmpty();
        }

        /**
         * @param value {@link #normalCodedValueSet} (The set of normal coded results for qualitative observations  that match the criteria of this set of qualified values.). This is the underlying object with id, value and extensions. The accessor "getNormalCodedValueSet" gives direct access to the value
         */
        public ObservationDefinitionQualifiedValueComponent setNormalCodedValueSetElement(CanonicalType value) { 
          this.normalCodedValueSet = value;
          return this;
        }

        /**
         * @return The set of normal coded results for qualitative observations  that match the criteria of this set of qualified values.
         */
        public String getNormalCodedValueSet() { 
          return this.normalCodedValueSet == null ? null : this.normalCodedValueSet.getValue();
        }

        /**
         * @param value The set of normal coded results for qualitative observations  that match the criteria of this set of qualified values.
         */
        public ObservationDefinitionQualifiedValueComponent setNormalCodedValueSet(String value) { 
          if (Utilities.noString(value))
            this.normalCodedValueSet = null;
          else {
            if (this.normalCodedValueSet == null)
              this.normalCodedValueSet = new CanonicalType();
            this.normalCodedValueSet.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #abnormalCodedValueSet} (The set of abnormal coded results for qualitative observations  that match the criteria of this set of qualified values.). This is the underlying object with id, value and extensions. The accessor "getAbnormalCodedValueSet" gives direct access to the value
         */
        public CanonicalType getAbnormalCodedValueSetElement() { 
          if (this.abnormalCodedValueSet == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationDefinitionQualifiedValueComponent.abnormalCodedValueSet");
            else if (Configuration.doAutoCreate())
              this.abnormalCodedValueSet = new CanonicalType(); // bb
          return this.abnormalCodedValueSet;
        }

        public boolean hasAbnormalCodedValueSetElement() { 
          return this.abnormalCodedValueSet != null && !this.abnormalCodedValueSet.isEmpty();
        }

        public boolean hasAbnormalCodedValueSet() { 
          return this.abnormalCodedValueSet != null && !this.abnormalCodedValueSet.isEmpty();
        }

        /**
         * @param value {@link #abnormalCodedValueSet} (The set of abnormal coded results for qualitative observations  that match the criteria of this set of qualified values.). This is the underlying object with id, value and extensions. The accessor "getAbnormalCodedValueSet" gives direct access to the value
         */
        public ObservationDefinitionQualifiedValueComponent setAbnormalCodedValueSetElement(CanonicalType value) { 
          this.abnormalCodedValueSet = value;
          return this;
        }

        /**
         * @return The set of abnormal coded results for qualitative observations  that match the criteria of this set of qualified values.
         */
        public String getAbnormalCodedValueSet() { 
          return this.abnormalCodedValueSet == null ? null : this.abnormalCodedValueSet.getValue();
        }

        /**
         * @param value The set of abnormal coded results for qualitative observations  that match the criteria of this set of qualified values.
         */
        public ObservationDefinitionQualifiedValueComponent setAbnormalCodedValueSet(String value) { 
          if (Utilities.noString(value))
            this.abnormalCodedValueSet = null;
          else {
            if (this.abnormalCodedValueSet == null)
              this.abnormalCodedValueSet = new CanonicalType();
            this.abnormalCodedValueSet.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #criticalCodedValueSet} (The set of critical coded results for qualitative observations  that match the criteria of this set of qualified values.). This is the underlying object with id, value and extensions. The accessor "getCriticalCodedValueSet" gives direct access to the value
         */
        public CanonicalType getCriticalCodedValueSetElement() { 
          if (this.criticalCodedValueSet == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationDefinitionQualifiedValueComponent.criticalCodedValueSet");
            else if (Configuration.doAutoCreate())
              this.criticalCodedValueSet = new CanonicalType(); // bb
          return this.criticalCodedValueSet;
        }

        public boolean hasCriticalCodedValueSetElement() { 
          return this.criticalCodedValueSet != null && !this.criticalCodedValueSet.isEmpty();
        }

        public boolean hasCriticalCodedValueSet() { 
          return this.criticalCodedValueSet != null && !this.criticalCodedValueSet.isEmpty();
        }

        /**
         * @param value {@link #criticalCodedValueSet} (The set of critical coded results for qualitative observations  that match the criteria of this set of qualified values.). This is the underlying object with id, value and extensions. The accessor "getCriticalCodedValueSet" gives direct access to the value
         */
        public ObservationDefinitionQualifiedValueComponent setCriticalCodedValueSetElement(CanonicalType value) { 
          this.criticalCodedValueSet = value;
          return this;
        }

        /**
         * @return The set of critical coded results for qualitative observations  that match the criteria of this set of qualified values.
         */
        public String getCriticalCodedValueSet() { 
          return this.criticalCodedValueSet == null ? null : this.criticalCodedValueSet.getValue();
        }

        /**
         * @param value The set of critical coded results for qualitative observations  that match the criteria of this set of qualified values.
         */
        public ObservationDefinitionQualifiedValueComponent setCriticalCodedValueSet(String value) { 
          if (Utilities.noString(value))
            this.criticalCodedValueSet = null;
          else {
            if (this.criticalCodedValueSet == null)
              this.criticalCodedValueSet = new CanonicalType();
            this.criticalCodedValueSet.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("context", "CodeableConcept", "A concept defining the context for this set of qualified values.", 0, 1, context));
          children.add(new Property("appliesTo", "CodeableConcept", "The target population this  set of qualified values applies to.", 0, java.lang.Integer.MAX_VALUE, appliesTo));
          children.add(new Property("gender", "code", "The gender this  set of qualified values applies to.", 0, 1, gender));
          children.add(new Property("age", "Range", "The age range this  set of qualified values applies to.", 0, 1, age));
          children.add(new Property("gestationalAge", "Range", "The gestational age this  set of qualified values applies to.", 0, 1, gestationalAge));
          children.add(new Property("condition", "string", "Text based condition for which the the set of qualified values is valid.", 0, 1, condition));
          children.add(new Property("rangeCategory", "code", "The category of range of values for continuous or ordinal observations that match the criteria of this set of qualified values.", 0, 1, rangeCategory));
          children.add(new Property("range", "Range", "The range of values defined for continuous or ordinal observations that match the criteria of this set of qualified values.", 0, 1, range));
          children.add(new Property("validCodedValueSet", "canonical(ValueSet)", "The set of valid coded results for qualitative observations  that match the criteria of this set of qualified values.", 0, 1, validCodedValueSet));
          children.add(new Property("normalCodedValueSet", "canonical(ValueSet)", "The set of normal coded results for qualitative observations  that match the criteria of this set of qualified values.", 0, 1, normalCodedValueSet));
          children.add(new Property("abnormalCodedValueSet", "canonical(ValueSet)", "The set of abnormal coded results for qualitative observations  that match the criteria of this set of qualified values.", 0, 1, abnormalCodedValueSet));
          children.add(new Property("criticalCodedValueSet", "canonical(ValueSet)", "The set of critical coded results for qualitative observations  that match the criteria of this set of qualified values.", 0, 1, criticalCodedValueSet));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 951530927: /*context*/  return new Property("context", "CodeableConcept", "A concept defining the context for this set of qualified values.", 0, 1, context);
          case -2089924569: /*appliesTo*/  return new Property("appliesTo", "CodeableConcept", "The target population this  set of qualified values applies to.", 0, java.lang.Integer.MAX_VALUE, appliesTo);
          case -1249512767: /*gender*/  return new Property("gender", "code", "The gender this  set of qualified values applies to.", 0, 1, gender);
          case 96511: /*age*/  return new Property("age", "Range", "The age range this  set of qualified values applies to.", 0, 1, age);
          case -241217538: /*gestationalAge*/  return new Property("gestationalAge", "Range", "The gestational age this  set of qualified values applies to.", 0, 1, gestationalAge);
          case -861311717: /*condition*/  return new Property("condition", "string", "Text based condition for which the the set of qualified values is valid.", 0, 1, condition);
          case -363410085: /*rangeCategory*/  return new Property("rangeCategory", "code", "The category of range of values for continuous or ordinal observations that match the criteria of this set of qualified values.", 0, 1, rangeCategory);
          case 108280125: /*range*/  return new Property("range", "Range", "The range of values defined for continuous or ordinal observations that match the criteria of this set of qualified values.", 0, 1, range);
          case 1374640076: /*validCodedValueSet*/  return new Property("validCodedValueSet", "canonical(ValueSet)", "The set of valid coded results for qualitative observations  that match the criteria of this set of qualified values.", 0, 1, validCodedValueSet);
          case -837500735: /*normalCodedValueSet*/  return new Property("normalCodedValueSet", "canonical(ValueSet)", "The set of normal coded results for qualitative observations  that match the criteria of this set of qualified values.", 0, 1, normalCodedValueSet);
          case 1073600256: /*abnormalCodedValueSet*/  return new Property("abnormalCodedValueSet", "canonical(ValueSet)", "The set of abnormal coded results for qualitative observations  that match the criteria of this set of qualified values.", 0, 1, abnormalCodedValueSet);
          case 2568457: /*criticalCodedValueSet*/  return new Property("criticalCodedValueSet", "canonical(ValueSet)", "The set of critical coded results for qualitative observations  that match the criteria of this set of qualified values.", 0, 1, criticalCodedValueSet);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 951530927: /*context*/ return this.context == null ? new Base[0] : new Base[] {this.context}; // CodeableConcept
        case -2089924569: /*appliesTo*/ return this.appliesTo == null ? new Base[0] : this.appliesTo.toArray(new Base[this.appliesTo.size()]); // CodeableConcept
        case -1249512767: /*gender*/ return this.gender == null ? new Base[0] : new Base[] {this.gender}; // Enumeration<AdministrativeGender>
        case 96511: /*age*/ return this.age == null ? new Base[0] : new Base[] {this.age}; // Range
        case -241217538: /*gestationalAge*/ return this.gestationalAge == null ? new Base[0] : new Base[] {this.gestationalAge}; // Range
        case -861311717: /*condition*/ return this.condition == null ? new Base[0] : new Base[] {this.condition}; // StringType
        case -363410085: /*rangeCategory*/ return this.rangeCategory == null ? new Base[0] : new Base[] {this.rangeCategory}; // Enumeration<ObservationRangeCategory>
        case 108280125: /*range*/ return this.range == null ? new Base[0] : new Base[] {this.range}; // Range
        case 1374640076: /*validCodedValueSet*/ return this.validCodedValueSet == null ? new Base[0] : new Base[] {this.validCodedValueSet}; // CanonicalType
        case -837500735: /*normalCodedValueSet*/ return this.normalCodedValueSet == null ? new Base[0] : new Base[] {this.normalCodedValueSet}; // CanonicalType
        case 1073600256: /*abnormalCodedValueSet*/ return this.abnormalCodedValueSet == null ? new Base[0] : new Base[] {this.abnormalCodedValueSet}; // CanonicalType
        case 2568457: /*criticalCodedValueSet*/ return this.criticalCodedValueSet == null ? new Base[0] : new Base[] {this.criticalCodedValueSet}; // CanonicalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 951530927: // context
          this.context = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -2089924569: // appliesTo
          this.getAppliesTo().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1249512767: // gender
          value = new AdministrativeGenderEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.gender = (Enumeration) value; // Enumeration<AdministrativeGender>
          return value;
        case 96511: // age
          this.age = TypeConvertor.castToRange(value); // Range
          return value;
        case -241217538: // gestationalAge
          this.gestationalAge = TypeConvertor.castToRange(value); // Range
          return value;
        case -861311717: // condition
          this.condition = TypeConvertor.castToString(value); // StringType
          return value;
        case -363410085: // rangeCategory
          value = new ObservationRangeCategoryEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.rangeCategory = (Enumeration) value; // Enumeration<ObservationRangeCategory>
          return value;
        case 108280125: // range
          this.range = TypeConvertor.castToRange(value); // Range
          return value;
        case 1374640076: // validCodedValueSet
          this.validCodedValueSet = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case -837500735: // normalCodedValueSet
          this.normalCodedValueSet = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 1073600256: // abnormalCodedValueSet
          this.abnormalCodedValueSet = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 2568457: // criticalCodedValueSet
          this.criticalCodedValueSet = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("context")) {
          this.context = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("appliesTo")) {
          this.getAppliesTo().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("gender")) {
          value = new AdministrativeGenderEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.gender = (Enumeration) value; // Enumeration<AdministrativeGender>
        } else if (name.equals("age")) {
          this.age = TypeConvertor.castToRange(value); // Range
        } else if (name.equals("gestationalAge")) {
          this.gestationalAge = TypeConvertor.castToRange(value); // Range
        } else if (name.equals("condition")) {
          this.condition = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("rangeCategory")) {
          value = new ObservationRangeCategoryEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.rangeCategory = (Enumeration) value; // Enumeration<ObservationRangeCategory>
        } else if (name.equals("range")) {
          this.range = TypeConvertor.castToRange(value); // Range
        } else if (name.equals("validCodedValueSet")) {
          this.validCodedValueSet = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("normalCodedValueSet")) {
          this.normalCodedValueSet = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("abnormalCodedValueSet")) {
          this.abnormalCodedValueSet = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("criticalCodedValueSet")) {
          this.criticalCodedValueSet = TypeConvertor.castToCanonical(value); // CanonicalType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 951530927:  return getContext();
        case -2089924569:  return addAppliesTo(); 
        case -1249512767:  return getGenderElement();
        case 96511:  return getAge();
        case -241217538:  return getGestationalAge();
        case -861311717:  return getConditionElement();
        case -363410085:  return getRangeCategoryElement();
        case 108280125:  return getRange();
        case 1374640076:  return getValidCodedValueSetElement();
        case -837500735:  return getNormalCodedValueSetElement();
        case 1073600256:  return getAbnormalCodedValueSetElement();
        case 2568457:  return getCriticalCodedValueSetElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 951530927: /*context*/ return new String[] {"CodeableConcept"};
        case -2089924569: /*appliesTo*/ return new String[] {"CodeableConcept"};
        case -1249512767: /*gender*/ return new String[] {"code"};
        case 96511: /*age*/ return new String[] {"Range"};
        case -241217538: /*gestationalAge*/ return new String[] {"Range"};
        case -861311717: /*condition*/ return new String[] {"string"};
        case -363410085: /*rangeCategory*/ return new String[] {"code"};
        case 108280125: /*range*/ return new String[] {"Range"};
        case 1374640076: /*validCodedValueSet*/ return new String[] {"canonical"};
        case -837500735: /*normalCodedValueSet*/ return new String[] {"canonical"};
        case 1073600256: /*abnormalCodedValueSet*/ return new String[] {"canonical"};
        case 2568457: /*criticalCodedValueSet*/ return new String[] {"canonical"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("context")) {
          this.context = new CodeableConcept();
          return this.context;
        }
        else if (name.equals("appliesTo")) {
          return addAppliesTo();
        }
        else if (name.equals("gender")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.qualifiedValue.gender");
        }
        else if (name.equals("age")) {
          this.age = new Range();
          return this.age;
        }
        else if (name.equals("gestationalAge")) {
          this.gestationalAge = new Range();
          return this.gestationalAge;
        }
        else if (name.equals("condition")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.qualifiedValue.condition");
        }
        else if (name.equals("rangeCategory")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.qualifiedValue.rangeCategory");
        }
        else if (name.equals("range")) {
          this.range = new Range();
          return this.range;
        }
        else if (name.equals("validCodedValueSet")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.qualifiedValue.validCodedValueSet");
        }
        else if (name.equals("normalCodedValueSet")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.qualifiedValue.normalCodedValueSet");
        }
        else if (name.equals("abnormalCodedValueSet")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.qualifiedValue.abnormalCodedValueSet");
        }
        else if (name.equals("criticalCodedValueSet")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.qualifiedValue.criticalCodedValueSet");
        }
        else
          return super.addChild(name);
      }

      public ObservationDefinitionQualifiedValueComponent copy() {
        ObservationDefinitionQualifiedValueComponent dst = new ObservationDefinitionQualifiedValueComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ObservationDefinitionQualifiedValueComponent dst) {
        super.copyValues(dst);
        dst.context = context == null ? null : context.copy();
        if (appliesTo != null) {
          dst.appliesTo = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : appliesTo)
            dst.appliesTo.add(i.copy());
        };
        dst.gender = gender == null ? null : gender.copy();
        dst.age = age == null ? null : age.copy();
        dst.gestationalAge = gestationalAge == null ? null : gestationalAge.copy();
        dst.condition = condition == null ? null : condition.copy();
        dst.rangeCategory = rangeCategory == null ? null : rangeCategory.copy();
        dst.range = range == null ? null : range.copy();
        dst.validCodedValueSet = validCodedValueSet == null ? null : validCodedValueSet.copy();
        dst.normalCodedValueSet = normalCodedValueSet == null ? null : normalCodedValueSet.copy();
        dst.abnormalCodedValueSet = abnormalCodedValueSet == null ? null : abnormalCodedValueSet.copy();
        dst.criticalCodedValueSet = criticalCodedValueSet == null ? null : criticalCodedValueSet.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ObservationDefinitionQualifiedValueComponent))
          return false;
        ObservationDefinitionQualifiedValueComponent o = (ObservationDefinitionQualifiedValueComponent) other_;
        return compareDeep(context, o.context, true) && compareDeep(appliesTo, o.appliesTo, true) && compareDeep(gender, o.gender, true)
           && compareDeep(age, o.age, true) && compareDeep(gestationalAge, o.gestationalAge, true) && compareDeep(condition, o.condition, true)
           && compareDeep(rangeCategory, o.rangeCategory, true) && compareDeep(range, o.range, true) && compareDeep(validCodedValueSet, o.validCodedValueSet, true)
           && compareDeep(normalCodedValueSet, o.normalCodedValueSet, true) && compareDeep(abnormalCodedValueSet, o.abnormalCodedValueSet, true)
           && compareDeep(criticalCodedValueSet, o.criticalCodedValueSet, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ObservationDefinitionQualifiedValueComponent))
          return false;
        ObservationDefinitionQualifiedValueComponent o = (ObservationDefinitionQualifiedValueComponent) other_;
        return compareValues(gender, o.gender, true) && compareValues(condition, o.condition, true) && compareValues(rangeCategory, o.rangeCategory, true)
           && compareValues(validCodedValueSet, o.validCodedValueSet, true) && compareValues(normalCodedValueSet, o.normalCodedValueSet, true)
           && compareValues(abnormalCodedValueSet, o.abnormalCodedValueSet, true) && compareValues(criticalCodedValueSet, o.criticalCodedValueSet, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(context, appliesTo, gender
          , age, gestationalAge, condition, rangeCategory, range, validCodedValueSet, normalCodedValueSet
          , abnormalCodedValueSet, criticalCodedValueSet);
      }

  public String fhirType() {
    return "ObservationDefinition.qualifiedValue";

  }

  }

    @Block()
    public static class ObservationDefinitionComponentComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Describes what will be observed.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Type of observation", formalDefinition="Describes what will be observed." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-codes")
        protected CodeableConcept code;

        /**
         * The data types allowed for the value element of the instance of this component observations.
         */
        @Child(name = "permittedDataType", type = {CodeType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Quantity | CodeableConcept | string | boolean | integer | Range | Ratio | SampledData | time | dateTime | Period", formalDefinition="The data types allowed for the value element of the instance of this component observations." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/permitted-data-type")
        protected List<Enumeration<ObservationDataType>> permittedDataType;

        /**
         * Characteristics for quantitative results of this observation.
         */
        @Child(name = "quantitativeDetails", type = {ObservationDefinitionQuantitativeDetailsComponent.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Characteristics of quantitative results", formalDefinition="Characteristics for quantitative results of this observation." )
        protected ObservationDefinitionQuantitativeDetailsComponent quantitativeDetails;

        /**
         * A set of qualified values associated with a context and a set of conditions -  provides a range for quantitative and ordinal observations and a collection of value sets for qualitative observations.
         */
        @Child(name = "qualifiedValue", type = {ObservationDefinitionQualifiedValueComponent.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Set of qualified values for observation results", formalDefinition="A set of qualified values associated with a context and a set of conditions -  provides a range for quantitative and ordinal observations and a collection of value sets for qualitative observations." )
        protected List<ObservationDefinitionQualifiedValueComponent> qualifiedValue;

        private static final long serialVersionUID = -369470835L;

    /**
     * Constructor
     */
      public ObservationDefinitionComponentComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ObservationDefinitionComponentComponent(CodeableConcept code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (Describes what will be observed.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationDefinitionComponentComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Describes what will be observed.)
         */
        public ObservationDefinitionComponentComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #permittedDataType} (The data types allowed for the value element of the instance of this component observations.)
         */
        public List<Enumeration<ObservationDataType>> getPermittedDataType() { 
          if (this.permittedDataType == null)
            this.permittedDataType = new ArrayList<Enumeration<ObservationDataType>>();
          return this.permittedDataType;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ObservationDefinitionComponentComponent setPermittedDataType(List<Enumeration<ObservationDataType>> thePermittedDataType) { 
          this.permittedDataType = thePermittedDataType;
          return this;
        }

        public boolean hasPermittedDataType() { 
          if (this.permittedDataType == null)
            return false;
          for (Enumeration<ObservationDataType> item : this.permittedDataType)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #permittedDataType} (The data types allowed for the value element of the instance of this component observations.)
         */
        public Enumeration<ObservationDataType> addPermittedDataTypeElement() {//2 
          Enumeration<ObservationDataType> t = new Enumeration<ObservationDataType>(new ObservationDataTypeEnumFactory());
          if (this.permittedDataType == null)
            this.permittedDataType = new ArrayList<Enumeration<ObservationDataType>>();
          this.permittedDataType.add(t);
          return t;
        }

        /**
         * @param value {@link #permittedDataType} (The data types allowed for the value element of the instance of this component observations.)
         */
        public ObservationDefinitionComponentComponent addPermittedDataType(ObservationDataType value) { //1
          Enumeration<ObservationDataType> t = new Enumeration<ObservationDataType>(new ObservationDataTypeEnumFactory());
          t.setValue(value);
          if (this.permittedDataType == null)
            this.permittedDataType = new ArrayList<Enumeration<ObservationDataType>>();
          this.permittedDataType.add(t);
          return this;
        }

        /**
         * @param value {@link #permittedDataType} (The data types allowed for the value element of the instance of this component observations.)
         */
        public boolean hasPermittedDataType(ObservationDataType value) { 
          if (this.permittedDataType == null)
            return false;
          for (Enumeration<ObservationDataType> v : this.permittedDataType)
            if (v.getValue().equals(value)) // code
              return true;
          return false;
        }

        /**
         * @return {@link #quantitativeDetails} (Characteristics for quantitative results of this observation.)
         */
        public ObservationDefinitionQuantitativeDetailsComponent getQuantitativeDetails() { 
          if (this.quantitativeDetails == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationDefinitionComponentComponent.quantitativeDetails");
            else if (Configuration.doAutoCreate())
              this.quantitativeDetails = new ObservationDefinitionQuantitativeDetailsComponent(); // cc
          return this.quantitativeDetails;
        }

        public boolean hasQuantitativeDetails() { 
          return this.quantitativeDetails != null && !this.quantitativeDetails.isEmpty();
        }

        /**
         * @param value {@link #quantitativeDetails} (Characteristics for quantitative results of this observation.)
         */
        public ObservationDefinitionComponentComponent setQuantitativeDetails(ObservationDefinitionQuantitativeDetailsComponent value) { 
          this.quantitativeDetails = value;
          return this;
        }

        /**
         * @return {@link #qualifiedValue} (A set of qualified values associated with a context and a set of conditions -  provides a range for quantitative and ordinal observations and a collection of value sets for qualitative observations.)
         */
        public List<ObservationDefinitionQualifiedValueComponent> getQualifiedValue() { 
          if (this.qualifiedValue == null)
            this.qualifiedValue = new ArrayList<ObservationDefinitionQualifiedValueComponent>();
          return this.qualifiedValue;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ObservationDefinitionComponentComponent setQualifiedValue(List<ObservationDefinitionQualifiedValueComponent> theQualifiedValue) { 
          this.qualifiedValue = theQualifiedValue;
          return this;
        }

        public boolean hasQualifiedValue() { 
          if (this.qualifiedValue == null)
            return false;
          for (ObservationDefinitionQualifiedValueComponent item : this.qualifiedValue)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ObservationDefinitionQualifiedValueComponent addQualifiedValue() { //3
          ObservationDefinitionQualifiedValueComponent t = new ObservationDefinitionQualifiedValueComponent();
          if (this.qualifiedValue == null)
            this.qualifiedValue = new ArrayList<ObservationDefinitionQualifiedValueComponent>();
          this.qualifiedValue.add(t);
          return t;
        }

        public ObservationDefinitionComponentComponent addQualifiedValue(ObservationDefinitionQualifiedValueComponent t) { //3
          if (t == null)
            return this;
          if (this.qualifiedValue == null)
            this.qualifiedValue = new ArrayList<ObservationDefinitionQualifiedValueComponent>();
          this.qualifiedValue.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #qualifiedValue}, creating it if it does not already exist {3}
         */
        public ObservationDefinitionQualifiedValueComponent getQualifiedValueFirstRep() { 
          if (getQualifiedValue().isEmpty()) {
            addQualifiedValue();
          }
          return getQualifiedValue().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "Describes what will be observed.", 0, 1, code));
          children.add(new Property("permittedDataType", "code", "The data types allowed for the value element of the instance of this component observations.", 0, java.lang.Integer.MAX_VALUE, permittedDataType));
          children.add(new Property("quantitativeDetails", "@ObservationDefinition.quantitativeDetails", "Characteristics for quantitative results of this observation.", 0, 1, quantitativeDetails));
          children.add(new Property("qualifiedValue", "@ObservationDefinition.qualifiedValue", "A set of qualified values associated with a context and a set of conditions -  provides a range for quantitative and ordinal observations and a collection of value sets for qualitative observations.", 0, java.lang.Integer.MAX_VALUE, qualifiedValue));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Describes what will be observed.", 0, 1, code);
          case -99492804: /*permittedDataType*/  return new Property("permittedDataType", "code", "The data types allowed for the value element of the instance of this component observations.", 0, java.lang.Integer.MAX_VALUE, permittedDataType);
          case 842150763: /*quantitativeDetails*/  return new Property("quantitativeDetails", "@ObservationDefinition.quantitativeDetails", "Characteristics for quantitative results of this observation.", 0, 1, quantitativeDetails);
          case -558517707: /*qualifiedValue*/  return new Property("qualifiedValue", "@ObservationDefinition.qualifiedValue", "A set of qualified values associated with a context and a set of conditions -  provides a range for quantitative and ordinal observations and a collection of value sets for qualitative observations.", 0, java.lang.Integer.MAX_VALUE, qualifiedValue);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -99492804: /*permittedDataType*/ return this.permittedDataType == null ? new Base[0] : this.permittedDataType.toArray(new Base[this.permittedDataType.size()]); // Enumeration<ObservationDataType>
        case 842150763: /*quantitativeDetails*/ return this.quantitativeDetails == null ? new Base[0] : new Base[] {this.quantitativeDetails}; // ObservationDefinitionQuantitativeDetailsComponent
        case -558517707: /*qualifiedValue*/ return this.qualifiedValue == null ? new Base[0] : this.qualifiedValue.toArray(new Base[this.qualifiedValue.size()]); // ObservationDefinitionQualifiedValueComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -99492804: // permittedDataType
          value = new ObservationDataTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getPermittedDataType().add((Enumeration) value); // Enumeration<ObservationDataType>
          return value;
        case 842150763: // quantitativeDetails
          this.quantitativeDetails = (ObservationDefinitionQuantitativeDetailsComponent) value; // ObservationDefinitionQuantitativeDetailsComponent
          return value;
        case -558517707: // qualifiedValue
          this.getQualifiedValue().add((ObservationDefinitionQualifiedValueComponent) value); // ObservationDefinitionQualifiedValueComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("permittedDataType")) {
          value = new ObservationDataTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getPermittedDataType().add((Enumeration) value);
        } else if (name.equals("quantitativeDetails")) {
          this.quantitativeDetails = (ObservationDefinitionQuantitativeDetailsComponent) value; // ObservationDefinitionQuantitativeDetailsComponent
        } else if (name.equals("qualifiedValue")) {
          this.getQualifiedValue().add((ObservationDefinitionQualifiedValueComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case -99492804:  return addPermittedDataTypeElement();
        case 842150763:  return getQuantitativeDetails();
        case -558517707:  return addQualifiedValue(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -99492804: /*permittedDataType*/ return new String[] {"code"};
        case 842150763: /*quantitativeDetails*/ return new String[] {"@ObservationDefinition.quantitativeDetails"};
        case -558517707: /*qualifiedValue*/ return new String[] {"@ObservationDefinition.qualifiedValue"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("permittedDataType")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.component.permittedDataType");
        }
        else if (name.equals("quantitativeDetails")) {
          this.quantitativeDetails = new ObservationDefinitionQuantitativeDetailsComponent();
          return this.quantitativeDetails;
        }
        else if (name.equals("qualifiedValue")) {
          return addQualifiedValue();
        }
        else
          return super.addChild(name);
      }

      public ObservationDefinitionComponentComponent copy() {
        ObservationDefinitionComponentComponent dst = new ObservationDefinitionComponentComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ObservationDefinitionComponentComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        if (permittedDataType != null) {
          dst.permittedDataType = new ArrayList<Enumeration<ObservationDataType>>();
          for (Enumeration<ObservationDataType> i : permittedDataType)
            dst.permittedDataType.add(i.copy());
        };
        dst.quantitativeDetails = quantitativeDetails == null ? null : quantitativeDetails.copy();
        if (qualifiedValue != null) {
          dst.qualifiedValue = new ArrayList<ObservationDefinitionQualifiedValueComponent>();
          for (ObservationDefinitionQualifiedValueComponent i : qualifiedValue)
            dst.qualifiedValue.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ObservationDefinitionComponentComponent))
          return false;
        ObservationDefinitionComponentComponent o = (ObservationDefinitionComponentComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(permittedDataType, o.permittedDataType, true)
           && compareDeep(quantitativeDetails, o.quantitativeDetails, true) && compareDeep(qualifiedValue, o.qualifiedValue, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ObservationDefinitionComponentComponent))
          return false;
        ObservationDefinitionComponentComponent o = (ObservationDefinitionComponentComponent) other_;
        return compareValues(permittedDataType, o.permittedDataType, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, permittedDataType, quantitativeDetails
          , qualifiedValue);
      }

  public String fhirType() {
    return "ObservationDefinition.component";

  }

  }

    /**
     * An absolute URL that is used to identify this ObservationDefinition when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this ObservationDefinition is (or will be) published. The URL SHOULD include the major version of the ObservationDefinition. For more information see Technical and Business Versions.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Logical canonical URL to reference this ObservationDefinition (globally unique)", formalDefinition="An absolute URL that is used to identify this ObservationDefinition when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this ObservationDefinition is (or will be) published. The URL SHOULD include the major version of the ObservationDefinition. For more information see Technical and Business Versions." )
    protected UriType url;

    /**
     * Business identifiers assigned to this ObservationDefinition. by the performer and/or other systems. These identifiers remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier of the ObservationDefinition", formalDefinition="Business identifiers assigned to this ObservationDefinition. by the performer and/or other systems. These identifiers remain constant as the resource is updated and propagates from server to server." )
    protected Identifier identifier;

    /**
     * The identifier that is used to identify this version of the ObservationDefinition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the ObservationDefinition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the ObservationDefinition", formalDefinition="The identifier that is used to identify this version of the ObservationDefinition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the ObservationDefinition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable." )
    protected StringType version;

    /**
     * A natural language name identifying the ObservationDefinition. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this ObservationDefinition (computer friendly)", formalDefinition="A natural language name identifying the ObservationDefinition. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the ObservationDefinition.
     */
    @Child(name = "title", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this ObservationDefinition (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the ObservationDefinition." )
    protected StringType title;

    /**
     * The current state of the ObservationDefinition.
     */
    @Child(name = "status", type = {CodeType.class}, order=5, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The current state of the ObservationDefinition." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A flag to indicate that this ObservationDefinition is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="If for testing purposes, not real usage", formalDefinition="A flag to indicate that this ObservationDefinition is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The date (and optionally time) when the ObservationDefinition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the ObservationDefinition changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date (and optionally time) when the ObservationDefinition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the ObservationDefinition changes." )
    protected DateTimeType date;

    /**
     * Helps establish the "authority/credibility" of the ObservationDefinition. May also allow for contact.
     */
    @Child(name = "publisher", type = {StringType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The name of the individual or organization that published the ObservationDefinition", formalDefinition="Helps establish the \"authority/credibility\" of the ObservationDefinition. May also allow for contact." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the ObservationDefinition from the consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the ObservationDefinition", formalDefinition="A free text natural language description of the ObservationDefinition from the consumer's perspective." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate ObservationDefinition instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Content intends to support these contexts", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate ObservationDefinition instances." )
    protected List<UsageContext> useContext;

    /**
     * A jurisdiction in which the ObservationDefinition is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for this ObservationDefinition (if applicable)", formalDefinition="A jurisdiction in which the ObservationDefinition is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explains why this ObservationDefinition is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this ObservationDefinition is defined", formalDefinition="Explains why this ObservationDefinition is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * Copyright statement relating to the ObservationDefinition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the ObservationDefinition.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="Copyright statement relating to the ObservationDefinition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the ObservationDefinition." )
    protected MarkdownType copyright;

    /**
     * The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    @Child(name = "approvalDate", type = {DateType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When ObservationDefinition was approved by publisher", formalDefinition="The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage." )
    protected DateType approvalDate;

    /**
     * The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.
     */
    @Child(name = "lastReviewDate", type = {DateType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Date on which the asset content was last reviewed", formalDefinition="The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date." )
    protected DateType lastReviewDate;

    /**
     * The period during which the ObservationDefinition content was or is planned to be effective.
     */
    @Child(name = "effectivePeriod", type = {Period.class}, order=17, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The effective date range for the ObservationDefinition", formalDefinition="The period during which the ObservationDefinition content was or is planned to be effective." )
    protected Period effectivePeriod;

    /**
     * The canonical URL pointing to another FHIR-defined ObservationDefinition that is adhered to in whole or in part by this definition.
     */
    @Child(name = "derivedFromCanonical", type = {CanonicalType.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Based on FHIR definition of another observation", formalDefinition="The canonical URL pointing to another FHIR-defined ObservationDefinition that is adhered to in whole or in part by this definition." )
    protected List<CanonicalType> derivedFromCanonical;

    /**
     * The URL pointing to an externally-defined observation definition, guideline or other definition that is adhered to in whole or in part by this definition.
     */
    @Child(name = "derivedFromUri", type = {UriType.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Based on external definition", formalDefinition="The URL pointing to an externally-defined observation definition, guideline or other definition that is adhered to in whole or in part by this definition." )
    protected List<UriType> derivedFromUri;

    /**
     * A code that describes the intended kind of subject of Observation instances conforming to this ObservationDefinition.
     */
    @Child(name = "subject", type = {CodeableConcept.class}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Type of subject for the defined observation", formalDefinition="A code that describes the intended kind of subject of Observation instances conforming to this ObservationDefinition." )
    protected List<CodeableConcept> subject;

    /**
     * The type of individual/organization/device that is expected to act upon instances of this definition.
     */
    @Child(name = "performerType", type = {CodeableConcept.class}, order=21, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Desired kind of performer for such kind of observation", formalDefinition="The type of individual/organization/device that is expected to act upon instances of this definition." )
    protected CodeableConcept performerType;

    /**
     * A code that classifies the general type of observation.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="General type of observation", formalDefinition="A code that classifies the general type of observation." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-category")
    protected List<CodeableConcept> category;

    /**
     * Describes what will be observed. Sometimes this is called the observation "name".
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=23, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Type of observation", formalDefinition="Describes what will be observed. Sometimes this is called the observation \"name\"." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-codes")
    protected CodeableConcept code;

    /**
     * The data types allowed for the value element of the instance observations conforming to this ObservationDefinition.
     */
    @Child(name = "permittedDataType", type = {CodeType.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Quantity | CodeableConcept | string | boolean | integer | Range | Ratio | SampledData | time | dateTime | Period", formalDefinition="The data types allowed for the value element of the instance observations conforming to this ObservationDefinition." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/permitted-data-type")
    protected List<Enumeration<ObservationDataType>> permittedDataType;

    /**
     * Multiple results allowed for observations conforming to this ObservationDefinition.
     */
    @Child(name = "multipleResultsAllowed", type = {BooleanType.class}, order=25, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Multiple results allowed for conforming observations", formalDefinition="Multiple results allowed for observations conforming to this ObservationDefinition." )
    protected BooleanType multipleResultsAllowed;

    /**
     * The site on the subject's body where the  observation is to be made.
     */
    @Child(name = "bodySite", type = {CodeableConcept.class}, order=26, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Body part to be observed", formalDefinition="The site on the subject's body where the  observation is to be made." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
    protected CodeableConcept bodySite;

    /**
     * The method or technique used to perform the observation.
     */
    @Child(name = "method", type = {CodeableConcept.class}, order=27, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Method used to produce the observation", formalDefinition="The method or technique used to perform the observation." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-methods")
    protected CodeableConcept method;

    /**
     * The kind of specimen that this type of observation is produced on.
     */
    @Child(name = "specimen", type = {SpecimenDefinition.class}, order=28, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Kind of specimen used by this type of observation", formalDefinition="The kind of specimen that this type of observation is produced on." )
    protected List<Reference> specimen;

    /**
     * The measurement model of device or actual device used to produce observations of this type.
     */
    @Child(name = "device", type = {DeviceDefinition.class, Device.class}, order=29, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Measurement device or model of device", formalDefinition="The measurement model of device or actual device used to produce observations of this type." )
    protected List<Reference> device;

    /**
     * The preferred name to be used when reporting the results of observations conforming to this ObservationDefinition.
     */
    @Child(name = "preferredReportName", type = {StringType.class}, order=30, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The preferred name to be used when reporting the observation results", formalDefinition="The preferred name to be used when reporting the results of observations conforming to this ObservationDefinition." )
    protected StringType preferredReportName;

    /**
     * Characteristics for quantitative results of observations conforming to this ObservationDefinition.
     */
    @Child(name = "quantitativeDetails", type = {}, order=31, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Characteristics of quantitative results", formalDefinition="Characteristics for quantitative results of observations conforming to this ObservationDefinition." )
    protected ObservationDefinitionQuantitativeDetailsComponent quantitativeDetails;

    /**
     * A set of qualified values associated with a context and a set of conditions -  provides a range for quantitative and ordinal observations and a collection of value sets for qualitative observations.
     */
    @Child(name = "qualifiedValue", type = {}, order=32, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Set of qualified values for observation results", formalDefinition="A set of qualified values associated with a context and a set of conditions -  provides a range for quantitative and ordinal observations and a collection of value sets for qualitative observations." )
    protected List<ObservationDefinitionQualifiedValueComponent> qualifiedValue;

    /**
     * This ObservationDefinition defines a group  observation (e.g. a battery, a panel of tests, a set of vital sign measurements) that includes the target as a member of the group.
     */
    @Child(name = "hasMember", type = {ObservationDefinition.class, Questionnaire.class}, order=33, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Definitions of related resources belonging to this kind of observation group", formalDefinition="This ObservationDefinition defines a group  observation (e.g. a battery, a panel of tests, a set of vital sign measurements) that includes the target as a member of the group." )
    protected List<Reference> hasMember;

    /**
     * Some observations have multiple component observations, expressed as separate code value pairs.
     */
    @Child(name = "component", type = {}, order=34, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Component results", formalDefinition="Some observations have multiple component observations, expressed as separate code value pairs." )
    protected List<ObservationDefinitionComponentComponent> component;

    private static final long serialVersionUID = -349400105L;

  /**
   * Constructor
   */
    public ObservationDefinition() {
      super();
    }

  /**
   * Constructor
   */
    public ObservationDefinition(PublicationStatus status, CodeableConcept code) {
      super();
      this.setStatus(status);
      this.setCode(code);
    }

    /**
     * @return {@link #url} (An absolute URL that is used to identify this ObservationDefinition when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this ObservationDefinition is (or will be) published. The URL SHOULD include the major version of the ObservationDefinition. For more information see Technical and Business Versions.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.url");
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
     * @param value {@link #url} (An absolute URL that is used to identify this ObservationDefinition when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this ObservationDefinition is (or will be) published. The URL SHOULD include the major version of the ObservationDefinition. For more information see Technical and Business Versions.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public ObservationDefinition setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URL that is used to identify this ObservationDefinition when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this ObservationDefinition is (or will be) published. The URL SHOULD include the major version of the ObservationDefinition. For more information see Technical and Business Versions.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URL that is used to identify this ObservationDefinition when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this ObservationDefinition is (or will be) published. The URL SHOULD include the major version of the ObservationDefinition. For more information see Technical and Business Versions.
     */
    public ObservationDefinition setUrl(String value) { 
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
     * @return {@link #identifier} (Business identifiers assigned to this ObservationDefinition. by the performer and/or other systems. These identifiers remain constant as the resource is updated and propagates from server to server.)
     */
    public Identifier getIdentifier() { 
      if (this.identifier == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.identifier");
        else if (Configuration.doAutoCreate())
          this.identifier = new Identifier(); // cc
      return this.identifier;
    }

    public boolean hasIdentifier() { 
      return this.identifier != null && !this.identifier.isEmpty();
    }

    /**
     * @param value {@link #identifier} (Business identifiers assigned to this ObservationDefinition. by the performer and/or other systems. These identifiers remain constant as the resource is updated and propagates from server to server.)
     */
    public ObservationDefinition setIdentifier(Identifier value) { 
      this.identifier = value;
      return this;
    }

    /**
     * @return {@link #version} (The identifier that is used to identify this version of the ObservationDefinition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the ObservationDefinition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the ObservationDefinition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the ObservationDefinition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public ObservationDefinition setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the ObservationDefinition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the ObservationDefinition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the ObservationDefinition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the ObservationDefinition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.
     */
    public ObservationDefinition setVersion(String value) { 
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
     * @return {@link #name} (A natural language name identifying the ObservationDefinition. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.name");
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
     * @param value {@link #name} (A natural language name identifying the ObservationDefinition. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public ObservationDefinition setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the ObservationDefinition. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the ObservationDefinition. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public ObservationDefinition setName(String value) { 
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
     * @return {@link #title} (A short, descriptive, user-friendly title for the ObservationDefinition.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.title");
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the ObservationDefinition.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public ObservationDefinition setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the ObservationDefinition.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the ObservationDefinition.
     */
    public ObservationDefinition setTitle(String value) { 
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
     * @return {@link #status} (The current state of the ObservationDefinition.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.status");
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
     * @param value {@link #status} (The current state of the ObservationDefinition.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public ObservationDefinition setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The current state of the ObservationDefinition.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The current state of the ObservationDefinition.
     */
    public ObservationDefinition setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A flag to indicate that this ObservationDefinition is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.experimental");
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
     * @param value {@link #experimental} (A flag to indicate that this ObservationDefinition is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public ObservationDefinition setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A flag to indicate that this ObservationDefinition is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A flag to indicate that this ObservationDefinition is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.
     */
    public ObservationDefinition setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (The date (and optionally time) when the ObservationDefinition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the ObservationDefinition changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.date");
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
     * @param value {@link #date} (The date (and optionally time) when the ObservationDefinition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the ObservationDefinition changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public ObservationDefinition setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date (and optionally time) when the ObservationDefinition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the ObservationDefinition changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date (and optionally time) when the ObservationDefinition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the ObservationDefinition changes.
     */
    public ObservationDefinition setDate(Date value) { 
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
     * @return {@link #publisher} (Helps establish the "authority/credibility" of the ObservationDefinition. May also allow for contact.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.publisher");
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
     * @param value {@link #publisher} (Helps establish the "authority/credibility" of the ObservationDefinition. May also allow for contact.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public ObservationDefinition setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return Helps establish the "authority/credibility" of the ObservationDefinition. May also allow for contact.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value Helps establish the "authority/credibility" of the ObservationDefinition. May also allow for contact.
     */
    public ObservationDefinition setPublisher(String value) { 
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
    public ObservationDefinition setContact(List<ContactDetail> theContact) { 
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

    public ObservationDefinition addContact(ContactDetail t) { //3
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
     * @return {@link #description} (A free text natural language description of the ObservationDefinition from the consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.description");
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
     * @param value {@link #description} (A free text natural language description of the ObservationDefinition from the consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public ObservationDefinition setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the ObservationDefinition from the consumer's perspective.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the ObservationDefinition from the consumer's perspective.
     */
    public ObservationDefinition setDescription(String value) { 
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
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate ObservationDefinition instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ObservationDefinition setUseContext(List<UsageContext> theUseContext) { 
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

    public ObservationDefinition addUseContext(UsageContext t) { //3
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
     * @return {@link #jurisdiction} (A jurisdiction in which the ObservationDefinition is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ObservationDefinition setJurisdiction(List<CodeableConcept> theJurisdiction) { 
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

    public ObservationDefinition addJurisdiction(CodeableConcept t) { //3
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
     * @return {@link #purpose} (Explains why this ObservationDefinition is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.purpose");
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
     * @param value {@link #purpose} (Explains why this ObservationDefinition is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public ObservationDefinition setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explains why this ObservationDefinition is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explains why this ObservationDefinition is needed and why it has been designed as it has.
     */
    public ObservationDefinition setPurpose(String value) { 
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
     * @return {@link #copyright} (Copyright statement relating to the ObservationDefinition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the ObservationDefinition.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.copyright");
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
     * @param value {@link #copyright} (Copyright statement relating to the ObservationDefinition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the ObservationDefinition.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public ObservationDefinition setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return Copyright statement relating to the ObservationDefinition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the ObservationDefinition.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value Copyright statement relating to the ObservationDefinition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the ObservationDefinition.
     */
    public ObservationDefinition setCopyright(String value) { 
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
     * @return {@link #approvalDate} (The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() { 
      if (this.approvalDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.approvalDate");
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
     * @param value {@link #approvalDate} (The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public ObservationDefinition setApprovalDateElement(DateType value) { 
      this.approvalDate = value;
      return this;
    }

    /**
     * @return The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public Date getApprovalDate() { 
      return this.approvalDate == null ? null : this.approvalDate.getValue();
    }

    /**
     * @param value The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public ObservationDefinition setApprovalDate(Date value) { 
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
     * @return {@link #lastReviewDate} (The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public DateType getLastReviewDateElement() { 
      if (this.lastReviewDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.lastReviewDate");
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
     * @param value {@link #lastReviewDate} (The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public ObservationDefinition setLastReviewDateElement(DateType value) { 
      this.lastReviewDate = value;
      return this;
    }

    /**
     * @return The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.
     */
    public Date getLastReviewDate() { 
      return this.lastReviewDate == null ? null : this.lastReviewDate.getValue();
    }

    /**
     * @param value The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.
     */
    public ObservationDefinition setLastReviewDate(Date value) { 
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
     * @return {@link #effectivePeriod} (The period during which the ObservationDefinition content was or is planned to be effective.)
     */
    public Period getEffectivePeriod() { 
      if (this.effectivePeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.effectivePeriod");
        else if (Configuration.doAutoCreate())
          this.effectivePeriod = new Period(); // cc
      return this.effectivePeriod;
    }

    public boolean hasEffectivePeriod() { 
      return this.effectivePeriod != null && !this.effectivePeriod.isEmpty();
    }

    /**
     * @param value {@link #effectivePeriod} (The period during which the ObservationDefinition content was or is planned to be effective.)
     */
    public ObservationDefinition setEffectivePeriod(Period value) { 
      this.effectivePeriod = value;
      return this;
    }

    /**
     * @return {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined ObservationDefinition that is adhered to in whole or in part by this definition.)
     */
    public List<CanonicalType> getDerivedFromCanonical() { 
      if (this.derivedFromCanonical == null)
        this.derivedFromCanonical = new ArrayList<CanonicalType>();
      return this.derivedFromCanonical;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ObservationDefinition setDerivedFromCanonical(List<CanonicalType> theDerivedFromCanonical) { 
      this.derivedFromCanonical = theDerivedFromCanonical;
      return this;
    }

    public boolean hasDerivedFromCanonical() { 
      if (this.derivedFromCanonical == null)
        return false;
      for (CanonicalType item : this.derivedFromCanonical)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined ObservationDefinition that is adhered to in whole or in part by this definition.)
     */
    public CanonicalType addDerivedFromCanonicalElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.derivedFromCanonical == null)
        this.derivedFromCanonical = new ArrayList<CanonicalType>();
      this.derivedFromCanonical.add(t);
      return t;
    }

    /**
     * @param value {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined ObservationDefinition that is adhered to in whole or in part by this definition.)
     */
    public ObservationDefinition addDerivedFromCanonical(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.derivedFromCanonical == null)
        this.derivedFromCanonical = new ArrayList<CanonicalType>();
      this.derivedFromCanonical.add(t);
      return this;
    }

    /**
     * @param value {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined ObservationDefinition that is adhered to in whole or in part by this definition.)
     */
    public boolean hasDerivedFromCanonical(String value) { 
      if (this.derivedFromCanonical == null)
        return false;
      for (CanonicalType v : this.derivedFromCanonical)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #derivedFromUri} (The URL pointing to an externally-defined observation definition, guideline or other definition that is adhered to in whole or in part by this definition.)
     */
    public List<UriType> getDerivedFromUri() { 
      if (this.derivedFromUri == null)
        this.derivedFromUri = new ArrayList<UriType>();
      return this.derivedFromUri;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ObservationDefinition setDerivedFromUri(List<UriType> theDerivedFromUri) { 
      this.derivedFromUri = theDerivedFromUri;
      return this;
    }

    public boolean hasDerivedFromUri() { 
      if (this.derivedFromUri == null)
        return false;
      for (UriType item : this.derivedFromUri)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #derivedFromUri} (The URL pointing to an externally-defined observation definition, guideline or other definition that is adhered to in whole or in part by this definition.)
     */
    public UriType addDerivedFromUriElement() {//2 
      UriType t = new UriType();
      if (this.derivedFromUri == null)
        this.derivedFromUri = new ArrayList<UriType>();
      this.derivedFromUri.add(t);
      return t;
    }

    /**
     * @param value {@link #derivedFromUri} (The URL pointing to an externally-defined observation definition, guideline or other definition that is adhered to in whole or in part by this definition.)
     */
    public ObservationDefinition addDerivedFromUri(String value) { //1
      UriType t = new UriType();
      t.setValue(value);
      if (this.derivedFromUri == null)
        this.derivedFromUri = new ArrayList<UriType>();
      this.derivedFromUri.add(t);
      return this;
    }

    /**
     * @param value {@link #derivedFromUri} (The URL pointing to an externally-defined observation definition, guideline or other definition that is adhered to in whole or in part by this definition.)
     */
    public boolean hasDerivedFromUri(String value) { 
      if (this.derivedFromUri == null)
        return false;
      for (UriType v : this.derivedFromUri)
        if (v.getValue().equals(value)) // uri
          return true;
      return false;
    }

    /**
     * @return {@link #subject} (A code that describes the intended kind of subject of Observation instances conforming to this ObservationDefinition.)
     */
    public List<CodeableConcept> getSubject() { 
      if (this.subject == null)
        this.subject = new ArrayList<CodeableConcept>();
      return this.subject;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ObservationDefinition setSubject(List<CodeableConcept> theSubject) { 
      this.subject = theSubject;
      return this;
    }

    public boolean hasSubject() { 
      if (this.subject == null)
        return false;
      for (CodeableConcept item : this.subject)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addSubject() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.subject == null)
        this.subject = new ArrayList<CodeableConcept>();
      this.subject.add(t);
      return t;
    }

    public ObservationDefinition addSubject(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.subject == null)
        this.subject = new ArrayList<CodeableConcept>();
      this.subject.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #subject}, creating it if it does not already exist {3}
     */
    public CodeableConcept getSubjectFirstRep() { 
      if (getSubject().isEmpty()) {
        addSubject();
      }
      return getSubject().get(0);
    }

    /**
     * @return {@link #performerType} (The type of individual/organization/device that is expected to act upon instances of this definition.)
     */
    public CodeableConcept getPerformerType() { 
      if (this.performerType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.performerType");
        else if (Configuration.doAutoCreate())
          this.performerType = new CodeableConcept(); // cc
      return this.performerType;
    }

    public boolean hasPerformerType() { 
      return this.performerType != null && !this.performerType.isEmpty();
    }

    /**
     * @param value {@link #performerType} (The type of individual/organization/device that is expected to act upon instances of this definition.)
     */
    public ObservationDefinition setPerformerType(CodeableConcept value) { 
      this.performerType = value;
      return this;
    }

    /**
     * @return {@link #category} (A code that classifies the general type of observation.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ObservationDefinition setCategory(List<CodeableConcept> theCategory) { 
      this.category = theCategory;
      return this;
    }

    public boolean hasCategory() { 
      if (this.category == null)
        return false;
      for (CodeableConcept item : this.category)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCategory() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return t;
    }

    public ObservationDefinition addCategory(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #category}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCategoryFirstRep() { 
      if (getCategory().isEmpty()) {
        addCategory();
      }
      return getCategory().get(0);
    }

    /**
     * @return {@link #code} (Describes what will be observed. Sometimes this is called the observation "name".)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Describes what will be observed. Sometimes this is called the observation "name".)
     */
    public ObservationDefinition setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #permittedDataType} (The data types allowed for the value element of the instance observations conforming to this ObservationDefinition.)
     */
    public List<Enumeration<ObservationDataType>> getPermittedDataType() { 
      if (this.permittedDataType == null)
        this.permittedDataType = new ArrayList<Enumeration<ObservationDataType>>();
      return this.permittedDataType;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ObservationDefinition setPermittedDataType(List<Enumeration<ObservationDataType>> thePermittedDataType) { 
      this.permittedDataType = thePermittedDataType;
      return this;
    }

    public boolean hasPermittedDataType() { 
      if (this.permittedDataType == null)
        return false;
      for (Enumeration<ObservationDataType> item : this.permittedDataType)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #permittedDataType} (The data types allowed for the value element of the instance observations conforming to this ObservationDefinition.)
     */
    public Enumeration<ObservationDataType> addPermittedDataTypeElement() {//2 
      Enumeration<ObservationDataType> t = new Enumeration<ObservationDataType>(new ObservationDataTypeEnumFactory());
      if (this.permittedDataType == null)
        this.permittedDataType = new ArrayList<Enumeration<ObservationDataType>>();
      this.permittedDataType.add(t);
      return t;
    }

    /**
     * @param value {@link #permittedDataType} (The data types allowed for the value element of the instance observations conforming to this ObservationDefinition.)
     */
    public ObservationDefinition addPermittedDataType(ObservationDataType value) { //1
      Enumeration<ObservationDataType> t = new Enumeration<ObservationDataType>(new ObservationDataTypeEnumFactory());
      t.setValue(value);
      if (this.permittedDataType == null)
        this.permittedDataType = new ArrayList<Enumeration<ObservationDataType>>();
      this.permittedDataType.add(t);
      return this;
    }

    /**
     * @param value {@link #permittedDataType} (The data types allowed for the value element of the instance observations conforming to this ObservationDefinition.)
     */
    public boolean hasPermittedDataType(ObservationDataType value) { 
      if (this.permittedDataType == null)
        return false;
      for (Enumeration<ObservationDataType> v : this.permittedDataType)
        if (v.getValue().equals(value)) // code
          return true;
      return false;
    }

    /**
     * @return {@link #multipleResultsAllowed} (Multiple results allowed for observations conforming to this ObservationDefinition.). This is the underlying object with id, value and extensions. The accessor "getMultipleResultsAllowed" gives direct access to the value
     */
    public BooleanType getMultipleResultsAllowedElement() { 
      if (this.multipleResultsAllowed == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.multipleResultsAllowed");
        else if (Configuration.doAutoCreate())
          this.multipleResultsAllowed = new BooleanType(); // bb
      return this.multipleResultsAllowed;
    }

    public boolean hasMultipleResultsAllowedElement() { 
      return this.multipleResultsAllowed != null && !this.multipleResultsAllowed.isEmpty();
    }

    public boolean hasMultipleResultsAllowed() { 
      return this.multipleResultsAllowed != null && !this.multipleResultsAllowed.isEmpty();
    }

    /**
     * @param value {@link #multipleResultsAllowed} (Multiple results allowed for observations conforming to this ObservationDefinition.). This is the underlying object with id, value and extensions. The accessor "getMultipleResultsAllowed" gives direct access to the value
     */
    public ObservationDefinition setMultipleResultsAllowedElement(BooleanType value) { 
      this.multipleResultsAllowed = value;
      return this;
    }

    /**
     * @return Multiple results allowed for observations conforming to this ObservationDefinition.
     */
    public boolean getMultipleResultsAllowed() { 
      return this.multipleResultsAllowed == null || this.multipleResultsAllowed.isEmpty() ? false : this.multipleResultsAllowed.getValue();
    }

    /**
     * @param value Multiple results allowed for observations conforming to this ObservationDefinition.
     */
    public ObservationDefinition setMultipleResultsAllowed(boolean value) { 
        if (this.multipleResultsAllowed == null)
          this.multipleResultsAllowed = new BooleanType();
        this.multipleResultsAllowed.setValue(value);
      return this;
    }

    /**
     * @return {@link #bodySite} (The site on the subject's body where the  observation is to be made.)
     */
    public CodeableConcept getBodySite() { 
      if (this.bodySite == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.bodySite");
        else if (Configuration.doAutoCreate())
          this.bodySite = new CodeableConcept(); // cc
      return this.bodySite;
    }

    public boolean hasBodySite() { 
      return this.bodySite != null && !this.bodySite.isEmpty();
    }

    /**
     * @param value {@link #bodySite} (The site on the subject's body where the  observation is to be made.)
     */
    public ObservationDefinition setBodySite(CodeableConcept value) { 
      this.bodySite = value;
      return this;
    }

    /**
     * @return {@link #method} (The method or technique used to perform the observation.)
     */
    public CodeableConcept getMethod() { 
      if (this.method == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.method");
        else if (Configuration.doAutoCreate())
          this.method = new CodeableConcept(); // cc
      return this.method;
    }

    public boolean hasMethod() { 
      return this.method != null && !this.method.isEmpty();
    }

    /**
     * @param value {@link #method} (The method or technique used to perform the observation.)
     */
    public ObservationDefinition setMethod(CodeableConcept value) { 
      this.method = value;
      return this;
    }

    /**
     * @return {@link #specimen} (The kind of specimen that this type of observation is produced on.)
     */
    public List<Reference> getSpecimen() { 
      if (this.specimen == null)
        this.specimen = new ArrayList<Reference>();
      return this.specimen;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ObservationDefinition setSpecimen(List<Reference> theSpecimen) { 
      this.specimen = theSpecimen;
      return this;
    }

    public boolean hasSpecimen() { 
      if (this.specimen == null)
        return false;
      for (Reference item : this.specimen)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSpecimen() { //3
      Reference t = new Reference();
      if (this.specimen == null)
        this.specimen = new ArrayList<Reference>();
      this.specimen.add(t);
      return t;
    }

    public ObservationDefinition addSpecimen(Reference t) { //3
      if (t == null)
        return this;
      if (this.specimen == null)
        this.specimen = new ArrayList<Reference>();
      this.specimen.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #specimen}, creating it if it does not already exist {3}
     */
    public Reference getSpecimenFirstRep() { 
      if (getSpecimen().isEmpty()) {
        addSpecimen();
      }
      return getSpecimen().get(0);
    }

    /**
     * @return {@link #device} (The measurement model of device or actual device used to produce observations of this type.)
     */
    public List<Reference> getDevice() { 
      if (this.device == null)
        this.device = new ArrayList<Reference>();
      return this.device;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ObservationDefinition setDevice(List<Reference> theDevice) { 
      this.device = theDevice;
      return this;
    }

    public boolean hasDevice() { 
      if (this.device == null)
        return false;
      for (Reference item : this.device)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addDevice() { //3
      Reference t = new Reference();
      if (this.device == null)
        this.device = new ArrayList<Reference>();
      this.device.add(t);
      return t;
    }

    public ObservationDefinition addDevice(Reference t) { //3
      if (t == null)
        return this;
      if (this.device == null)
        this.device = new ArrayList<Reference>();
      this.device.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #device}, creating it if it does not already exist {3}
     */
    public Reference getDeviceFirstRep() { 
      if (getDevice().isEmpty()) {
        addDevice();
      }
      return getDevice().get(0);
    }

    /**
     * @return {@link #preferredReportName} (The preferred name to be used when reporting the results of observations conforming to this ObservationDefinition.). This is the underlying object with id, value and extensions. The accessor "getPreferredReportName" gives direct access to the value
     */
    public StringType getPreferredReportNameElement() { 
      if (this.preferredReportName == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.preferredReportName");
        else if (Configuration.doAutoCreate())
          this.preferredReportName = new StringType(); // bb
      return this.preferredReportName;
    }

    public boolean hasPreferredReportNameElement() { 
      return this.preferredReportName != null && !this.preferredReportName.isEmpty();
    }

    public boolean hasPreferredReportName() { 
      return this.preferredReportName != null && !this.preferredReportName.isEmpty();
    }

    /**
     * @param value {@link #preferredReportName} (The preferred name to be used when reporting the results of observations conforming to this ObservationDefinition.). This is the underlying object with id, value and extensions. The accessor "getPreferredReportName" gives direct access to the value
     */
    public ObservationDefinition setPreferredReportNameElement(StringType value) { 
      this.preferredReportName = value;
      return this;
    }

    /**
     * @return The preferred name to be used when reporting the results of observations conforming to this ObservationDefinition.
     */
    public String getPreferredReportName() { 
      return this.preferredReportName == null ? null : this.preferredReportName.getValue();
    }

    /**
     * @param value The preferred name to be used when reporting the results of observations conforming to this ObservationDefinition.
     */
    public ObservationDefinition setPreferredReportName(String value) { 
      if (Utilities.noString(value))
        this.preferredReportName = null;
      else {
        if (this.preferredReportName == null)
          this.preferredReportName = new StringType();
        this.preferredReportName.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #quantitativeDetails} (Characteristics for quantitative results of observations conforming to this ObservationDefinition.)
     */
    public ObservationDefinitionQuantitativeDetailsComponent getQuantitativeDetails() { 
      if (this.quantitativeDetails == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ObservationDefinition.quantitativeDetails");
        else if (Configuration.doAutoCreate())
          this.quantitativeDetails = new ObservationDefinitionQuantitativeDetailsComponent(); // cc
      return this.quantitativeDetails;
    }

    public boolean hasQuantitativeDetails() { 
      return this.quantitativeDetails != null && !this.quantitativeDetails.isEmpty();
    }

    /**
     * @param value {@link #quantitativeDetails} (Characteristics for quantitative results of observations conforming to this ObservationDefinition.)
     */
    public ObservationDefinition setQuantitativeDetails(ObservationDefinitionQuantitativeDetailsComponent value) { 
      this.quantitativeDetails = value;
      return this;
    }

    /**
     * @return {@link #qualifiedValue} (A set of qualified values associated with a context and a set of conditions -  provides a range for quantitative and ordinal observations and a collection of value sets for qualitative observations.)
     */
    public List<ObservationDefinitionQualifiedValueComponent> getQualifiedValue() { 
      if (this.qualifiedValue == null)
        this.qualifiedValue = new ArrayList<ObservationDefinitionQualifiedValueComponent>();
      return this.qualifiedValue;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ObservationDefinition setQualifiedValue(List<ObservationDefinitionQualifiedValueComponent> theQualifiedValue) { 
      this.qualifiedValue = theQualifiedValue;
      return this;
    }

    public boolean hasQualifiedValue() { 
      if (this.qualifiedValue == null)
        return false;
      for (ObservationDefinitionQualifiedValueComponent item : this.qualifiedValue)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ObservationDefinitionQualifiedValueComponent addQualifiedValue() { //3
      ObservationDefinitionQualifiedValueComponent t = new ObservationDefinitionQualifiedValueComponent();
      if (this.qualifiedValue == null)
        this.qualifiedValue = new ArrayList<ObservationDefinitionQualifiedValueComponent>();
      this.qualifiedValue.add(t);
      return t;
    }

    public ObservationDefinition addQualifiedValue(ObservationDefinitionQualifiedValueComponent t) { //3
      if (t == null)
        return this;
      if (this.qualifiedValue == null)
        this.qualifiedValue = new ArrayList<ObservationDefinitionQualifiedValueComponent>();
      this.qualifiedValue.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #qualifiedValue}, creating it if it does not already exist {3}
     */
    public ObservationDefinitionQualifiedValueComponent getQualifiedValueFirstRep() { 
      if (getQualifiedValue().isEmpty()) {
        addQualifiedValue();
      }
      return getQualifiedValue().get(0);
    }

    /**
     * @return {@link #hasMember} (This ObservationDefinition defines a group  observation (e.g. a battery, a panel of tests, a set of vital sign measurements) that includes the target as a member of the group.)
     */
    public List<Reference> getHasMember() { 
      if (this.hasMember == null)
        this.hasMember = new ArrayList<Reference>();
      return this.hasMember;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ObservationDefinition setHasMember(List<Reference> theHasMember) { 
      this.hasMember = theHasMember;
      return this;
    }

    public boolean hasHasMember() { 
      if (this.hasMember == null)
        return false;
      for (Reference item : this.hasMember)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addHasMember() { //3
      Reference t = new Reference();
      if (this.hasMember == null)
        this.hasMember = new ArrayList<Reference>();
      this.hasMember.add(t);
      return t;
    }

    public ObservationDefinition addHasMember(Reference t) { //3
      if (t == null)
        return this;
      if (this.hasMember == null)
        this.hasMember = new ArrayList<Reference>();
      this.hasMember.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #hasMember}, creating it if it does not already exist {3}
     */
    public Reference getHasMemberFirstRep() { 
      if (getHasMember().isEmpty()) {
        addHasMember();
      }
      return getHasMember().get(0);
    }

    /**
     * @return {@link #component} (Some observations have multiple component observations, expressed as separate code value pairs.)
     */
    public List<ObservationDefinitionComponentComponent> getComponent() { 
      if (this.component == null)
        this.component = new ArrayList<ObservationDefinitionComponentComponent>();
      return this.component;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ObservationDefinition setComponent(List<ObservationDefinitionComponentComponent> theComponent) { 
      this.component = theComponent;
      return this;
    }

    public boolean hasComponent() { 
      if (this.component == null)
        return false;
      for (ObservationDefinitionComponentComponent item : this.component)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ObservationDefinitionComponentComponent addComponent() { //3
      ObservationDefinitionComponentComponent t = new ObservationDefinitionComponentComponent();
      if (this.component == null)
        this.component = new ArrayList<ObservationDefinitionComponentComponent>();
      this.component.add(t);
      return t;
    }

    public ObservationDefinition addComponent(ObservationDefinitionComponentComponent t) { //3
      if (t == null)
        return this;
      if (this.component == null)
        this.component = new ArrayList<ObservationDefinitionComponentComponent>();
      this.component.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #component}, creating it if it does not already exist {3}
     */
    public ObservationDefinitionComponentComponent getComponentFirstRep() { 
      if (getComponent().isEmpty()) {
        addComponent();
      }
      return getComponent().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URL that is used to identify this ObservationDefinition when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this ObservationDefinition is (or will be) published. The URL SHOULD include the major version of the ObservationDefinition. For more information see Technical and Business Versions.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "Business identifiers assigned to this ObservationDefinition. by the performer and/or other systems. These identifiers remain constant as the resource is updated and propagates from server to server.", 0, 1, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the ObservationDefinition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the ObservationDefinition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.", 0, 1, version));
        children.add(new Property("name", "string", "A natural language name identifying the ObservationDefinition. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the ObservationDefinition.", 0, 1, title));
        children.add(new Property("status", "code", "The current state of the ObservationDefinition.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A flag to indicate that this ObservationDefinition is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "The date (and optionally time) when the ObservationDefinition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the ObservationDefinition changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "Helps establish the \"authority/credibility\" of the ObservationDefinition. May also allow for contact.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the ObservationDefinition from the consumer's perspective.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate ObservationDefinition instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A jurisdiction in which the ObservationDefinition is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explains why this ObservationDefinition is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "Copyright statement relating to the ObservationDefinition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the ObservationDefinition.", 0, 1, copyright));
        children.add(new Property("approvalDate", "date", "The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate));
        children.add(new Property("lastReviewDate", "date", "The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.", 0, 1, lastReviewDate));
        children.add(new Property("effectivePeriod", "Period", "The period during which the ObservationDefinition content was or is planned to be effective.", 0, 1, effectivePeriod));
        children.add(new Property("derivedFromCanonical", "canonical(ObservationDefinition)", "The canonical URL pointing to another FHIR-defined ObservationDefinition that is adhered to in whole or in part by this definition.", 0, java.lang.Integer.MAX_VALUE, derivedFromCanonical));
        children.add(new Property("derivedFromUri", "uri", "The URL pointing to an externally-defined observation definition, guideline or other definition that is adhered to in whole or in part by this definition.", 0, java.lang.Integer.MAX_VALUE, derivedFromUri));
        children.add(new Property("subject", "CodeableConcept", "A code that describes the intended kind of subject of Observation instances conforming to this ObservationDefinition.", 0, java.lang.Integer.MAX_VALUE, subject));
        children.add(new Property("performerType", "CodeableConcept", "The type of individual/organization/device that is expected to act upon instances of this definition.", 0, 1, performerType));
        children.add(new Property("category", "CodeableConcept", "A code that classifies the general type of observation.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("code", "CodeableConcept", "Describes what will be observed. Sometimes this is called the observation \"name\".", 0, 1, code));
        children.add(new Property("permittedDataType", "code", "The data types allowed for the value element of the instance observations conforming to this ObservationDefinition.", 0, java.lang.Integer.MAX_VALUE, permittedDataType));
        children.add(new Property("multipleResultsAllowed", "boolean", "Multiple results allowed for observations conforming to this ObservationDefinition.", 0, 1, multipleResultsAllowed));
        children.add(new Property("bodySite", "CodeableConcept", "The site on the subject's body where the  observation is to be made.", 0, 1, bodySite));
        children.add(new Property("method", "CodeableConcept", "The method or technique used to perform the observation.", 0, 1, method));
        children.add(new Property("specimen", "Reference(SpecimenDefinition)", "The kind of specimen that this type of observation is produced on.", 0, java.lang.Integer.MAX_VALUE, specimen));
        children.add(new Property("device", "Reference(DeviceDefinition|Device)", "The measurement model of device or actual device used to produce observations of this type.", 0, java.lang.Integer.MAX_VALUE, device));
        children.add(new Property("preferredReportName", "string", "The preferred name to be used when reporting the results of observations conforming to this ObservationDefinition.", 0, 1, preferredReportName));
        children.add(new Property("quantitativeDetails", "", "Characteristics for quantitative results of observations conforming to this ObservationDefinition.", 0, 1, quantitativeDetails));
        children.add(new Property("qualifiedValue", "", "A set of qualified values associated with a context and a set of conditions -  provides a range for quantitative and ordinal observations and a collection of value sets for qualitative observations.", 0, java.lang.Integer.MAX_VALUE, qualifiedValue));
        children.add(new Property("hasMember", "Reference(ObservationDefinition|Questionnaire)", "This ObservationDefinition defines a group  observation (e.g. a battery, a panel of tests, a set of vital sign measurements) that includes the target as a member of the group.", 0, java.lang.Integer.MAX_VALUE, hasMember));
        children.add(new Property("component", "", "Some observations have multiple component observations, expressed as separate code value pairs.", 0, java.lang.Integer.MAX_VALUE, component));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URL that is used to identify this ObservationDefinition when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this ObservationDefinition is (or will be) published. The URL SHOULD include the major version of the ObservationDefinition. For more information see Technical and Business Versions.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifiers assigned to this ObservationDefinition. by the performer and/or other systems. These identifiers remain constant as the resource is updated and propagates from server to server.", 0, 1, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the ObservationDefinition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the ObservationDefinition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.", 0, 1, version);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the ObservationDefinition. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the ObservationDefinition.", 0, 1, title);
        case -892481550: /*status*/  return new Property("status", "code", "The current state of the ObservationDefinition.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A flag to indicate that this ObservationDefinition is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date (and optionally time) when the ObservationDefinition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the ObservationDefinition changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "Helps establish the \"authority/credibility\" of the ObservationDefinition. May also allow for contact.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the ObservationDefinition from the consumer's perspective.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate ObservationDefinition instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A jurisdiction in which the ObservationDefinition is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explains why this ObservationDefinition is needed and why it has been designed as it has.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "Copyright statement relating to the ObservationDefinition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the ObservationDefinition.", 0, 1, copyright);
        case 223539345: /*approvalDate*/  return new Property("approvalDate", "date", "The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate);
        case -1687512484: /*lastReviewDate*/  return new Property("lastReviewDate", "date", "The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.", 0, 1, lastReviewDate);
        case -403934648: /*effectivePeriod*/  return new Property("effectivePeriod", "Period", "The period during which the ObservationDefinition content was or is planned to be effective.", 0, 1, effectivePeriod);
        case -978133683: /*derivedFromCanonical*/  return new Property("derivedFromCanonical", "canonical(ObservationDefinition)", "The canonical URL pointing to another FHIR-defined ObservationDefinition that is adhered to in whole or in part by this definition.", 0, java.lang.Integer.MAX_VALUE, derivedFromCanonical);
        case -1076333435: /*derivedFromUri*/  return new Property("derivedFromUri", "uri", "The URL pointing to an externally-defined observation definition, guideline or other definition that is adhered to in whole or in part by this definition.", 0, java.lang.Integer.MAX_VALUE, derivedFromUri);
        case -1867885268: /*subject*/  return new Property("subject", "CodeableConcept", "A code that describes the intended kind of subject of Observation instances conforming to this ObservationDefinition.", 0, java.lang.Integer.MAX_VALUE, subject);
        case -901444568: /*performerType*/  return new Property("performerType", "CodeableConcept", "The type of individual/organization/device that is expected to act upon instances of this definition.", 0, 1, performerType);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "A code that classifies the general type of observation.", 0, java.lang.Integer.MAX_VALUE, category);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Describes what will be observed. Sometimes this is called the observation \"name\".", 0, 1, code);
        case -99492804: /*permittedDataType*/  return new Property("permittedDataType", "code", "The data types allowed for the value element of the instance observations conforming to this ObservationDefinition.", 0, java.lang.Integer.MAX_VALUE, permittedDataType);
        case -2102414590: /*multipleResultsAllowed*/  return new Property("multipleResultsAllowed", "boolean", "Multiple results allowed for observations conforming to this ObservationDefinition.", 0, 1, multipleResultsAllowed);
        case 1702620169: /*bodySite*/  return new Property("bodySite", "CodeableConcept", "The site on the subject's body where the  observation is to be made.", 0, 1, bodySite);
        case -1077554975: /*method*/  return new Property("method", "CodeableConcept", "The method or technique used to perform the observation.", 0, 1, method);
        case -2132868344: /*specimen*/  return new Property("specimen", "Reference(SpecimenDefinition)", "The kind of specimen that this type of observation is produced on.", 0, java.lang.Integer.MAX_VALUE, specimen);
        case -1335157162: /*device*/  return new Property("device", "Reference(DeviceDefinition|Device)", "The measurement model of device or actual device used to produce observations of this type.", 0, java.lang.Integer.MAX_VALUE, device);
        case -1851030208: /*preferredReportName*/  return new Property("preferredReportName", "string", "The preferred name to be used when reporting the results of observations conforming to this ObservationDefinition.", 0, 1, preferredReportName);
        case 842150763: /*quantitativeDetails*/  return new Property("quantitativeDetails", "", "Characteristics for quantitative results of observations conforming to this ObservationDefinition.", 0, 1, quantitativeDetails);
        case -558517707: /*qualifiedValue*/  return new Property("qualifiedValue", "", "A set of qualified values associated with a context and a set of conditions -  provides a range for quantitative and ordinal observations and a collection of value sets for qualitative observations.", 0, java.lang.Integer.MAX_VALUE, qualifiedValue);
        case -458019372: /*hasMember*/  return new Property("hasMember", "Reference(ObservationDefinition|Questionnaire)", "This ObservationDefinition defines a group  observation (e.g. a battery, a panel of tests, a set of vital sign measurements) that includes the target as a member of the group.", 0, java.lang.Integer.MAX_VALUE, hasMember);
        case -1399907075: /*component*/  return new Property("component", "", "Some observations have multiple component observations, expressed as separate code value pairs.", 0, java.lang.Integer.MAX_VALUE, component);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : new Base[] {this.identifier}; // Identifier
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
        case 223539345: /*approvalDate*/ return this.approvalDate == null ? new Base[0] : new Base[] {this.approvalDate}; // DateType
        case -1687512484: /*lastReviewDate*/ return this.lastReviewDate == null ? new Base[0] : new Base[] {this.lastReviewDate}; // DateType
        case -403934648: /*effectivePeriod*/ return this.effectivePeriod == null ? new Base[0] : new Base[] {this.effectivePeriod}; // Period
        case -978133683: /*derivedFromCanonical*/ return this.derivedFromCanonical == null ? new Base[0] : this.derivedFromCanonical.toArray(new Base[this.derivedFromCanonical.size()]); // CanonicalType
        case -1076333435: /*derivedFromUri*/ return this.derivedFromUri == null ? new Base[0] : this.derivedFromUri.toArray(new Base[this.derivedFromUri.size()]); // UriType
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : this.subject.toArray(new Base[this.subject.size()]); // CodeableConcept
        case -901444568: /*performerType*/ return this.performerType == null ? new Base[0] : new Base[] {this.performerType}; // CodeableConcept
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -99492804: /*permittedDataType*/ return this.permittedDataType == null ? new Base[0] : this.permittedDataType.toArray(new Base[this.permittedDataType.size()]); // Enumeration<ObservationDataType>
        case -2102414590: /*multipleResultsAllowed*/ return this.multipleResultsAllowed == null ? new Base[0] : new Base[] {this.multipleResultsAllowed}; // BooleanType
        case 1702620169: /*bodySite*/ return this.bodySite == null ? new Base[0] : new Base[] {this.bodySite}; // CodeableConcept
        case -1077554975: /*method*/ return this.method == null ? new Base[0] : new Base[] {this.method}; // CodeableConcept
        case -2132868344: /*specimen*/ return this.specimen == null ? new Base[0] : this.specimen.toArray(new Base[this.specimen.size()]); // Reference
        case -1335157162: /*device*/ return this.device == null ? new Base[0] : this.device.toArray(new Base[this.device.size()]); // Reference
        case -1851030208: /*preferredReportName*/ return this.preferredReportName == null ? new Base[0] : new Base[] {this.preferredReportName}; // StringType
        case 842150763: /*quantitativeDetails*/ return this.quantitativeDetails == null ? new Base[0] : new Base[] {this.quantitativeDetails}; // ObservationDefinitionQuantitativeDetailsComponent
        case -558517707: /*qualifiedValue*/ return this.qualifiedValue == null ? new Base[0] : this.qualifiedValue.toArray(new Base[this.qualifiedValue.size()]); // ObservationDefinitionQualifiedValueComponent
        case -458019372: /*hasMember*/ return this.hasMember == null ? new Base[0] : this.hasMember.toArray(new Base[this.hasMember.size()]); // Reference
        case -1399907075: /*component*/ return this.component == null ? new Base[0] : this.component.toArray(new Base[this.component.size()]); // ObservationDefinitionComponentComponent
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
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
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
        case 223539345: // approvalDate
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case -1687512484: // lastReviewDate
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case -403934648: // effectivePeriod
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
          return value;
        case -978133683: // derivedFromCanonical
          this.getDerivedFromCanonical().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case -1076333435: // derivedFromUri
          this.getDerivedFromUri().add(TypeConvertor.castToUri(value)); // UriType
          return value;
        case -1867885268: // subject
          this.getSubject().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -901444568: // performerType
          this.performerType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -99492804: // permittedDataType
          value = new ObservationDataTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getPermittedDataType().add((Enumeration) value); // Enumeration<ObservationDataType>
          return value;
        case -2102414590: // multipleResultsAllowed
          this.multipleResultsAllowed = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 1702620169: // bodySite
          this.bodySite = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1077554975: // method
          this.method = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -2132868344: // specimen
          this.getSpecimen().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1335157162: // device
          this.getDevice().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1851030208: // preferredReportName
          this.preferredReportName = TypeConvertor.castToString(value); // StringType
          return value;
        case 842150763: // quantitativeDetails
          this.quantitativeDetails = (ObservationDefinitionQuantitativeDetailsComponent) value; // ObservationDefinitionQuantitativeDetailsComponent
          return value;
        case -558517707: // qualifiedValue
          this.getQualifiedValue().add((ObservationDefinitionQualifiedValueComponent) value); // ObservationDefinitionQualifiedValueComponent
          return value;
        case -458019372: // hasMember
          this.getHasMember().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1399907075: // component
          this.getComponent().add((ObservationDefinitionComponentComponent) value); // ObservationDefinitionComponentComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("identifier")) {
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
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
        } else if (name.equals("approvalDate")) {
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("lastReviewDate")) {
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("derivedFromCanonical")) {
          this.getDerivedFromCanonical().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("derivedFromUri")) {
          this.getDerivedFromUri().add(TypeConvertor.castToUri(value));
        } else if (name.equals("subject")) {
          this.getSubject().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("performerType")) {
          this.performerType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("permittedDataType")) {
          value = new ObservationDataTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getPermittedDataType().add((Enumeration) value);
        } else if (name.equals("multipleResultsAllowed")) {
          this.multipleResultsAllowed = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("bodySite")) {
          this.bodySite = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("method")) {
          this.method = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("specimen")) {
          this.getSpecimen().add(TypeConvertor.castToReference(value));
        } else if (name.equals("device")) {
          this.getDevice().add(TypeConvertor.castToReference(value));
        } else if (name.equals("preferredReportName")) {
          this.preferredReportName = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("quantitativeDetails")) {
          this.quantitativeDetails = (ObservationDefinitionQuantitativeDetailsComponent) value; // ObservationDefinitionQuantitativeDetailsComponent
        } else if (name.equals("qualifiedValue")) {
          this.getQualifiedValue().add((ObservationDefinitionQualifiedValueComponent) value);
        } else if (name.equals("hasMember")) {
          this.getHasMember().add(TypeConvertor.castToReference(value));
        } else if (name.equals("component")) {
          this.getComponent().add((ObservationDefinitionComponentComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case -1618432855:  return getIdentifier();
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
        case 223539345:  return getApprovalDateElement();
        case -1687512484:  return getLastReviewDateElement();
        case -403934648:  return getEffectivePeriod();
        case -978133683:  return addDerivedFromCanonicalElement();
        case -1076333435:  return addDerivedFromUriElement();
        case -1867885268:  return addSubject(); 
        case -901444568:  return getPerformerType();
        case 50511102:  return addCategory(); 
        case 3059181:  return getCode();
        case -99492804:  return addPermittedDataTypeElement();
        case -2102414590:  return getMultipleResultsAllowedElement();
        case 1702620169:  return getBodySite();
        case -1077554975:  return getMethod();
        case -2132868344:  return addSpecimen(); 
        case -1335157162:  return addDevice(); 
        case -1851030208:  return getPreferredReportNameElement();
        case 842150763:  return getQuantitativeDetails();
        case -558517707:  return addQualifiedValue(); 
        case -458019372:  return addHasMember(); 
        case -1399907075:  return addComponent(); 
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
        case 223539345: /*approvalDate*/ return new String[] {"date"};
        case -1687512484: /*lastReviewDate*/ return new String[] {"date"};
        case -403934648: /*effectivePeriod*/ return new String[] {"Period"};
        case -978133683: /*derivedFromCanonical*/ return new String[] {"canonical"};
        case -1076333435: /*derivedFromUri*/ return new String[] {"uri"};
        case -1867885268: /*subject*/ return new String[] {"CodeableConcept"};
        case -901444568: /*performerType*/ return new String[] {"CodeableConcept"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -99492804: /*permittedDataType*/ return new String[] {"code"};
        case -2102414590: /*multipleResultsAllowed*/ return new String[] {"boolean"};
        case 1702620169: /*bodySite*/ return new String[] {"CodeableConcept"};
        case -1077554975: /*method*/ return new String[] {"CodeableConcept"};
        case -2132868344: /*specimen*/ return new String[] {"Reference"};
        case -1335157162: /*device*/ return new String[] {"Reference"};
        case -1851030208: /*preferredReportName*/ return new String[] {"string"};
        case 842150763: /*quantitativeDetails*/ return new String[] {};
        case -558517707: /*qualifiedValue*/ return new String[] {};
        case -458019372: /*hasMember*/ return new String[] {"Reference"};
        case -1399907075: /*component*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.url");
        }
        else if (name.equals("identifier")) {
          this.identifier = new Identifier();
          return this.identifier;
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.version");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.title");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.copyright");
        }
        else if (name.equals("approvalDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.approvalDate");
        }
        else if (name.equals("lastReviewDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.lastReviewDate");
        }
        else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = new Period();
          return this.effectivePeriod;
        }
        else if (name.equals("derivedFromCanonical")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.derivedFromCanonical");
        }
        else if (name.equals("derivedFromUri")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.derivedFromUri");
        }
        else if (name.equals("subject")) {
          return addSubject();
        }
        else if (name.equals("performerType")) {
          this.performerType = new CodeableConcept();
          return this.performerType;
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("permittedDataType")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.permittedDataType");
        }
        else if (name.equals("multipleResultsAllowed")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.multipleResultsAllowed");
        }
        else if (name.equals("bodySite")) {
          this.bodySite = new CodeableConcept();
          return this.bodySite;
        }
        else if (name.equals("method")) {
          this.method = new CodeableConcept();
          return this.method;
        }
        else if (name.equals("specimen")) {
          return addSpecimen();
        }
        else if (name.equals("device")) {
          return addDevice();
        }
        else if (name.equals("preferredReportName")) {
          throw new FHIRException("Cannot call addChild on a primitive type ObservationDefinition.preferredReportName");
        }
        else if (name.equals("quantitativeDetails")) {
          this.quantitativeDetails = new ObservationDefinitionQuantitativeDetailsComponent();
          return this.quantitativeDetails;
        }
        else if (name.equals("qualifiedValue")) {
          return addQualifiedValue();
        }
        else if (name.equals("hasMember")) {
          return addHasMember();
        }
        else if (name.equals("component")) {
          return addComponent();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ObservationDefinition";

  }

      public ObservationDefinition copy() {
        ObservationDefinition dst = new ObservationDefinition();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ObservationDefinition dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        dst.identifier = identifier == null ? null : identifier.copy();
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
        dst.approvalDate = approvalDate == null ? null : approvalDate.copy();
        dst.lastReviewDate = lastReviewDate == null ? null : lastReviewDate.copy();
        dst.effectivePeriod = effectivePeriod == null ? null : effectivePeriod.copy();
        if (derivedFromCanonical != null) {
          dst.derivedFromCanonical = new ArrayList<CanonicalType>();
          for (CanonicalType i : derivedFromCanonical)
            dst.derivedFromCanonical.add(i.copy());
        };
        if (derivedFromUri != null) {
          dst.derivedFromUri = new ArrayList<UriType>();
          for (UriType i : derivedFromUri)
            dst.derivedFromUri.add(i.copy());
        };
        if (subject != null) {
          dst.subject = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : subject)
            dst.subject.add(i.copy());
        };
        dst.performerType = performerType == null ? null : performerType.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.code = code == null ? null : code.copy();
        if (permittedDataType != null) {
          dst.permittedDataType = new ArrayList<Enumeration<ObservationDataType>>();
          for (Enumeration<ObservationDataType> i : permittedDataType)
            dst.permittedDataType.add(i.copy());
        };
        dst.multipleResultsAllowed = multipleResultsAllowed == null ? null : multipleResultsAllowed.copy();
        dst.bodySite = bodySite == null ? null : bodySite.copy();
        dst.method = method == null ? null : method.copy();
        if (specimen != null) {
          dst.specimen = new ArrayList<Reference>();
          for (Reference i : specimen)
            dst.specimen.add(i.copy());
        };
        if (device != null) {
          dst.device = new ArrayList<Reference>();
          for (Reference i : device)
            dst.device.add(i.copy());
        };
        dst.preferredReportName = preferredReportName == null ? null : preferredReportName.copy();
        dst.quantitativeDetails = quantitativeDetails == null ? null : quantitativeDetails.copy();
        if (qualifiedValue != null) {
          dst.qualifiedValue = new ArrayList<ObservationDefinitionQualifiedValueComponent>();
          for (ObservationDefinitionQualifiedValueComponent i : qualifiedValue)
            dst.qualifiedValue.add(i.copy());
        };
        if (hasMember != null) {
          dst.hasMember = new ArrayList<Reference>();
          for (Reference i : hasMember)
            dst.hasMember.add(i.copy());
        };
        if (component != null) {
          dst.component = new ArrayList<ObservationDefinitionComponentComponent>();
          for (ObservationDefinitionComponentComponent i : component)
            dst.component.add(i.copy());
        };
      }

      protected ObservationDefinition typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ObservationDefinition))
          return false;
        ObservationDefinition o = (ObservationDefinition) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(name, o.name, true) && compareDeep(title, o.title, true) && compareDeep(status, o.status, true)
           && compareDeep(experimental, o.experimental, true) && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true)
           && compareDeep(contact, o.contact, true) && compareDeep(description, o.description, true) && compareDeep(useContext, o.useContext, true)
           && compareDeep(jurisdiction, o.jurisdiction, true) && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true)
           && compareDeep(approvalDate, o.approvalDate, true) && compareDeep(lastReviewDate, o.lastReviewDate, true)
           && compareDeep(effectivePeriod, o.effectivePeriod, true) && compareDeep(derivedFromCanonical, o.derivedFromCanonical, true)
           && compareDeep(derivedFromUri, o.derivedFromUri, true) && compareDeep(subject, o.subject, true)
           && compareDeep(performerType, o.performerType, true) && compareDeep(category, o.category, true)
           && compareDeep(code, o.code, true) && compareDeep(permittedDataType, o.permittedDataType, true)
           && compareDeep(multipleResultsAllowed, o.multipleResultsAllowed, true) && compareDeep(bodySite, o.bodySite, true)
           && compareDeep(method, o.method, true) && compareDeep(specimen, o.specimen, true) && compareDeep(device, o.device, true)
           && compareDeep(preferredReportName, o.preferredReportName, true) && compareDeep(quantitativeDetails, o.quantitativeDetails, true)
           && compareDeep(qualifiedValue, o.qualifiedValue, true) && compareDeep(hasMember, o.hasMember, true)
           && compareDeep(component, o.component, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ObservationDefinition))
          return false;
        ObservationDefinition o = (ObservationDefinition) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true)
           && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true) && compareValues(description, o.description, true)
           && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true) && compareValues(approvalDate, o.approvalDate, true)
           && compareValues(lastReviewDate, o.lastReviewDate, true) && compareValues(derivedFromCanonical, o.derivedFromCanonical, true)
           && compareValues(derivedFromUri, o.derivedFromUri, true) && compareValues(permittedDataType, o.permittedDataType, true)
           && compareValues(multipleResultsAllowed, o.multipleResultsAllowed, true) && compareValues(preferredReportName, o.preferredReportName, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , name, title, status, experimental, date, publisher, contact, description, useContext
          , jurisdiction, purpose, copyright, approvalDate, lastReviewDate, effectivePeriod
          , derivedFromCanonical, derivedFromUri, subject, performerType, category, code, permittedDataType
          , multipleResultsAllowed, bodySite, method, specimen, device, preferredReportName
          , quantitativeDetails, qualifiedValue, hasMember, component);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ObservationDefinition;
   }

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
   * Search parameter: <b>category</b>
   * <p>
   * Description: <b>Category (class) of observation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ObservationDefinition.category</b><br>
   * </p>
   */
  @SearchParamDefinition(name="category", path="ObservationDefinition.category", description="Category (class) of observation", type="token" )
  public static final String SP_CATEGORY = "category";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>category</b>
   * <p>
   * Description: <b>Category (class) of observation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ObservationDefinition.category</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CATEGORY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CATEGORY);

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>Observation code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ObservationDefinition.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="ObservationDefinition.code", description="Observation code", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>Observation code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ObservationDefinition.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>experimental</b>
   * <p>
   * Description: <b>Not for genuine usage (true)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ObservationDefinition.experimental</b><br>
   * </p>
   */
  @SearchParamDefinition(name="experimental", path="ObservationDefinition.experimental", description="Not for genuine usage (true)", type="token" )
  public static final String SP_EXPERIMENTAL = "experimental";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>experimental</b>
   * <p>
   * Description: <b>Not for genuine usage (true)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ObservationDefinition.experimental</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam EXPERIMENTAL = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_EXPERIMENTAL);

 /**
   * Search parameter: <b>method</b>
   * <p>
   * Description: <b>Method of observation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ObservationDefinition.method</b><br>
   * </p>
   */
  @SearchParamDefinition(name="method", path="ObservationDefinition.method", description="Method of observation", type="token" )
  public static final String SP_METHOD = "method";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>method</b>
   * <p>
   * Description: <b>Method of observation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ObservationDefinition.method</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam METHOD = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_METHOD);


}
