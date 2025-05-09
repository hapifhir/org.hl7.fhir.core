package org.hl7.fhir.r5.openehr;


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
import org.hl7.fhir.r5.openehr.Enumerations.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * Quantitified type representing scientific quantities, i.e. quantities expressed as a magnitude and units. Units are expressed in the UCUM syntax (Unified Code for Units of Measure (UCUM), by Gunther Schadow and Clement J. McDonald of The Regenstrief Institute) (case-sensitive form) by default, or another system if units_system is set.

Can also be used for time durations, where it is more convenient to treat these as simply a number of seconds rather than days, months, years (in the latter case, DV_DURATION may be used).
 */
@DatatypeDef(name="DV_QUANTITY")
public class DV_QUANTITY extends DV_AMOUNT implements ICompositeType {

    /**
     * Numeric magnitude of the quantity.
     */
    @Child(name = "magnitude", type = {DecimalType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Numeric magnitude of the quantity", formalDefinition="Numeric magnitude of the quantity." )
    protected DecimalType magnitude;

    /**
     * Precision to which the value of the quantity is expressed, in terms of number of decimal places. The value 0 implies an integral quantity. The value -1 implies no limit, i.e. any number of decimal places
     */
    @Child(name = "precision", type = {IntegerType.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Precision to which the value of the quantity is expressed, in terms of number of decimal places. The value 0 implies an integral quantity. The value -1 implies no limit, i.e. any number of decimal places", formalDefinition="Precision to which the value of the quantity is expressed, in terms of number of decimal places. The value 0 implies an integral quantity. The value -1 implies no limit, i.e. any number of decimal places" )
    protected IntegerType precision;

    /**
     * Quantity units, expressed as a code or syntax string from either UCUM (the default) or the units system specified in units_system, when set.

In either case, the value is the code or syntax - normally formed of standard ASCII - which is in principal not the same as the display string, although in simple cases such as 'm' (for meters) it will be.

If the units_display_name field is set, this may be used for display. If not, the implementations must effect the resolution of the units value to a display form locally, e.g. by lookup of reference tables, request to a terminology service etc.


Example values from UCUM: 'kg/m^2', 'mm[Hg]', 'ms-1', 'km/h'
     */
    @Child(name = "units", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Quantity units, expressed as a code or syntax string from either UCUM (the default) or the units system specified in units_system, when set", formalDefinition="Quantity units, expressed as a code or syntax string from either UCUM (the default) or the units system specified in units_system, when set.\r\n\r\nIn either case, the value is the code or syntax - normally formed of standard ASCII - which is in principal not the same as the display string, although in simple cases such as 'm' (for meters) it will be.\r\n\r\nIf the units_display_name field is set, this may be used for display. If not, the implementations must effect the resolution of the units value to a display form locally, e.g. by lookup of reference tables, request to a terminology service etc.\r\n\r\n\r\nExample values from UCUM: 'kg/m^2', 'mm[Hg]', 'ms-1', 'km/h'" )
    protected StringType units;

    /**
     * Optional field used to specify a units system from which codes in units are defined. Value is a URI identifying a terminology containing units concepts from the (HL7 FHIR terminologies list).

If not set, the UCUM standard (case-sensitive codes) is assumed as the units system.
     */
    @Child(name = "units_system", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="URI identifying a terminology containing units concepts (from the FHIR terminologies list). UCUM is default", formalDefinition="Optional field used to specify a units system from which codes in units are defined. Value is a URI identifying a terminology containing units concepts from the (HL7 FHIR terminologies list).\r\n\r\nIf not set, the UCUM standard (case-sensitive codes) is assumed as the units system." )
    protected StringType units_system;

    /**
     * Optional field containing the displayable form of the units field, e.g. '°C'.

If not set, the application environment needs to determine the displayable form.
     */
    @Child(name = "units_display_name", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional field containing the displayable form of the units field, e.g. '°C'", formalDefinition="Optional field containing the displayable form of the units field, e.g. '°C'.\r\n\r\nIf not set, the application environment needs to determine the displayable form." )
    protected StringType units_display_name;

    private static final long serialVersionUID = -290777252L;

  /**
   * Constructor
   */
    public DV_QUANTITY() {
      super();
    }

  /**
   * Constructor
   */
    public DV_QUANTITY(BigDecimal magnitude, String units) {
      super();
      this.setMagnitude(magnitude);
      this.setUnits(units);
    }

    /**
     * @return {@link #magnitude} (Numeric magnitude of the quantity.). This is the underlying object with id, value and extensions. The accessor "getMagnitude" gives direct access to the value
     */
    public DecimalType getMagnitudeElement() { 
      if (this.magnitude == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_QUANTITY.magnitude");
        else if (Configuration.doAutoCreate())
          this.magnitude = new DecimalType(); // bb
      return this.magnitude;
    }

    public boolean hasMagnitudeElement() { 
      return this.magnitude != null && !this.magnitude.isEmpty();
    }

    public boolean hasMagnitude() { 
      return this.magnitude != null && !this.magnitude.isEmpty();
    }

    /**
     * @param value {@link #magnitude} (Numeric magnitude of the quantity.). This is the underlying object with id, value and extensions. The accessor "getMagnitude" gives direct access to the value
     */
    public DV_QUANTITY setMagnitudeElement(DecimalType value) { 
      this.magnitude = value;
      return this;
    }

    /**
     * @return Numeric magnitude of the quantity.
     */
    public BigDecimal getMagnitude() { 
      return this.magnitude == null ? null : this.magnitude.getValue();
    }

    /**
     * @param value Numeric magnitude of the quantity.
     */
    public DV_QUANTITY setMagnitude(BigDecimal value) { 
        if (this.magnitude == null)
          this.magnitude = new DecimalType();
        this.magnitude.setValue(value);
      return this;
    }

    /**
     * @param value Numeric magnitude of the quantity.
     */
    public DV_QUANTITY setMagnitude(long value) { 
          this.magnitude = new DecimalType();
        this.magnitude.setValue(value);
      return this;
    }

    /**
     * @param value Numeric magnitude of the quantity.
     */
    public DV_QUANTITY setMagnitude(double value) { 
          this.magnitude = new DecimalType();
        this.magnitude.setValue(value);
      return this;
    }

    /**
     * @return {@link #precision} (Precision to which the value of the quantity is expressed, in terms of number of decimal places. The value 0 implies an integral quantity. The value -1 implies no limit, i.e. any number of decimal places). This is the underlying object with id, value and extensions. The accessor "getPrecision" gives direct access to the value
     */
    public IntegerType getPrecisionElement() { 
      if (this.precision == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_QUANTITY.precision");
        else if (Configuration.doAutoCreate())
          this.precision = new IntegerType(); // bb
      return this.precision;
    }

    public boolean hasPrecisionElement() { 
      return this.precision != null && !this.precision.isEmpty();
    }

    public boolean hasPrecision() { 
      return this.precision != null && !this.precision.isEmpty();
    }

    /**
     * @param value {@link #precision} (Precision to which the value of the quantity is expressed, in terms of number of decimal places. The value 0 implies an integral quantity. The value -1 implies no limit, i.e. any number of decimal places). This is the underlying object with id, value and extensions. The accessor "getPrecision" gives direct access to the value
     */
    public DV_QUANTITY setPrecisionElement(IntegerType value) { 
      this.precision = value;
      return this;
    }

    /**
     * @return Precision to which the value of the quantity is expressed, in terms of number of decimal places. The value 0 implies an integral quantity. The value -1 implies no limit, i.e. any number of decimal places
     */
    public int getPrecision() { 
      return this.precision == null || this.precision.isEmpty() ? 0 : this.precision.getValue();
    }

    /**
     * @param value Precision to which the value of the quantity is expressed, in terms of number of decimal places. The value 0 implies an integral quantity. The value -1 implies no limit, i.e. any number of decimal places
     */
    public DV_QUANTITY setPrecision(int value) { 
        if (this.precision == null)
          this.precision = new IntegerType();
        this.precision.setValue(value);
      return this;
    }

    /**
     * @return {@link #units} (Quantity units, expressed as a code or syntax string from either UCUM (the default) or the units system specified in units_system, when set.

In either case, the value is the code or syntax - normally formed of standard ASCII - which is in principal not the same as the display string, although in simple cases such as 'm' (for meters) it will be.

If the units_display_name field is set, this may be used for display. If not, the implementations must effect the resolution of the units value to a display form locally, e.g. by lookup of reference tables, request to a terminology service etc.


Example values from UCUM: 'kg/m^2', 'mm[Hg]', 'ms-1', 'km/h'). This is the underlying object with id, value and extensions. The accessor "getUnits" gives direct access to the value
     */
    public StringType getUnitsElement() { 
      if (this.units == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_QUANTITY.units");
        else if (Configuration.doAutoCreate())
          this.units = new StringType(); // bb
      return this.units;
    }

    public boolean hasUnitsElement() { 
      return this.units != null && !this.units.isEmpty();
    }

    public boolean hasUnits() { 
      return this.units != null && !this.units.isEmpty();
    }

    /**
     * @param value {@link #units} (Quantity units, expressed as a code or syntax string from either UCUM (the default) or the units system specified in units_system, when set.

In either case, the value is the code or syntax - normally formed of standard ASCII - which is in principal not the same as the display string, although in simple cases such as 'm' (for meters) it will be.

If the units_display_name field is set, this may be used for display. If not, the implementations must effect the resolution of the units value to a display form locally, e.g. by lookup of reference tables, request to a terminology service etc.


Example values from UCUM: 'kg/m^2', 'mm[Hg]', 'ms-1', 'km/h'). This is the underlying object with id, value and extensions. The accessor "getUnits" gives direct access to the value
     */
    public DV_QUANTITY setUnitsElement(StringType value) { 
      this.units = value;
      return this;
    }

    /**
     * @return Quantity units, expressed as a code or syntax string from either UCUM (the default) or the units system specified in units_system, when set.

In either case, the value is the code or syntax - normally formed of standard ASCII - which is in principal not the same as the display string, although in simple cases such as 'm' (for meters) it will be.

If the units_display_name field is set, this may be used for display. If not, the implementations must effect the resolution of the units value to a display form locally, e.g. by lookup of reference tables, request to a terminology service etc.


Example values from UCUM: 'kg/m^2', 'mm[Hg]', 'ms-1', 'km/h'
     */
    public String getUnits() { 
      return this.units == null ? null : this.units.getValue();
    }

    /**
     * @param value Quantity units, expressed as a code or syntax string from either UCUM (the default) or the units system specified in units_system, when set.

In either case, the value is the code or syntax - normally formed of standard ASCII - which is in principal not the same as the display string, although in simple cases such as 'm' (for meters) it will be.

If the units_display_name field is set, this may be used for display. If not, the implementations must effect the resolution of the units value to a display form locally, e.g. by lookup of reference tables, request to a terminology service etc.


Example values from UCUM: 'kg/m^2', 'mm[Hg]', 'ms-1', 'km/h'
     */
    public DV_QUANTITY setUnits(String value) { 
        if (this.units == null)
          this.units = new StringType();
        this.units.setValue(value);
      return this;
    }

    /**
     * @return {@link #units_system} (Optional field used to specify a units system from which codes in units are defined. Value is a URI identifying a terminology containing units concepts from the (HL7 FHIR terminologies list).

If not set, the UCUM standard (case-sensitive codes) is assumed as the units system.). This is the underlying object with id, value and extensions. The accessor "getUnits_system" gives direct access to the value
     */
    public StringType getUnits_systemElement() { 
      if (this.units_system == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_QUANTITY.units_system");
        else if (Configuration.doAutoCreate())
          this.units_system = new StringType(); // bb
      return this.units_system;
    }

    public boolean hasUnits_systemElement() { 
      return this.units_system != null && !this.units_system.isEmpty();
    }

    public boolean hasUnits_system() { 
      return this.units_system != null && !this.units_system.isEmpty();
    }

    /**
     * @param value {@link #units_system} (Optional field used to specify a units system from which codes in units are defined. Value is a URI identifying a terminology containing units concepts from the (HL7 FHIR terminologies list).

If not set, the UCUM standard (case-sensitive codes) is assumed as the units system.). This is the underlying object with id, value and extensions. The accessor "getUnits_system" gives direct access to the value
     */
    public DV_QUANTITY setUnits_systemElement(StringType value) { 
      this.units_system = value;
      return this;
    }

    /**
     * @return Optional field used to specify a units system from which codes in units are defined. Value is a URI identifying a terminology containing units concepts from the (HL7 FHIR terminologies list).

If not set, the UCUM standard (case-sensitive codes) is assumed as the units system.
     */
    public String getUnits_system() { 
      return this.units_system == null ? null : this.units_system.getValue();
    }

    /**
     * @param value Optional field used to specify a units system from which codes in units are defined. Value is a URI identifying a terminology containing units concepts from the (HL7 FHIR terminologies list).

If not set, the UCUM standard (case-sensitive codes) is assumed as the units system.
     */
    public DV_QUANTITY setUnits_system(String value) { 
      if (Utilities.noString(value))
        this.units_system = null;
      else {
        if (this.units_system == null)
          this.units_system = new StringType();
        this.units_system.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #units_display_name} (Optional field containing the displayable form of the units field, e.g. '°C'.

If not set, the application environment needs to determine the displayable form.). This is the underlying object with id, value and extensions. The accessor "getUnits_display_name" gives direct access to the value
     */
    public StringType getUnits_display_nameElement() { 
      if (this.units_display_name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_QUANTITY.units_display_name");
        else if (Configuration.doAutoCreate())
          this.units_display_name = new StringType(); // bb
      return this.units_display_name;
    }

    public boolean hasUnits_display_nameElement() { 
      return this.units_display_name != null && !this.units_display_name.isEmpty();
    }

    public boolean hasUnits_display_name() { 
      return this.units_display_name != null && !this.units_display_name.isEmpty();
    }

    /**
     * @param value {@link #units_display_name} (Optional field containing the displayable form of the units field, e.g. '°C'.

If not set, the application environment needs to determine the displayable form.). This is the underlying object with id, value and extensions. The accessor "getUnits_display_name" gives direct access to the value
     */
    public DV_QUANTITY setUnits_display_nameElement(StringType value) { 
      this.units_display_name = value;
      return this;
    }

    /**
     * @return Optional field containing the displayable form of the units field, e.g. '°C'.

If not set, the application environment needs to determine the displayable form.
     */
    public String getUnits_display_name() { 
      return this.units_display_name == null ? null : this.units_display_name.getValue();
    }

    /**
     * @param value Optional field containing the displayable form of the units field, e.g. '°C'.

If not set, the application environment needs to determine the displayable form.
     */
    public DV_QUANTITY setUnits_display_name(String value) { 
      if (Utilities.noString(value))
        this.units_display_name = null;
      else {
        if (this.units_display_name == null)
          this.units_display_name = new StringType();
        this.units_display_name.setValue(value);
      }
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("magnitude", "decimal", "Numeric magnitude of the quantity.", 0, 1, magnitude));
        children.add(new Property("precision", "integer", "Precision to which the value of the quantity is expressed, in terms of number of decimal places. The value 0 implies an integral quantity. The value -1 implies no limit, i.e. any number of decimal places", 0, 1, precision));
        children.add(new Property("units", "string", "Quantity units, expressed as a code or syntax string from either UCUM (the default) or the units system specified in units_system, when set.\r\n\r\nIn either case, the value is the code or syntax - normally formed of standard ASCII - which is in principal not the same as the display string, although in simple cases such as 'm' (for meters) it will be.\r\n\r\nIf the units_display_name field is set, this may be used for display. If not, the implementations must effect the resolution of the units value to a display form locally, e.g. by lookup of reference tables, request to a terminology service etc.\r\n\r\n\r\nExample values from UCUM: 'kg/m^2', 'mm[Hg]', 'ms-1', 'km/h'", 0, 1, units));
        children.add(new Property("units_system", "string", "Optional field used to specify a units system from which codes in units are defined. Value is a URI identifying a terminology containing units concepts from the (HL7 FHIR terminologies list).\r\n\r\nIf not set, the UCUM standard (case-sensitive codes) is assumed as the units system.", 0, 1, units_system));
        children.add(new Property("units_display_name", "string", "Optional field containing the displayable form of the units field, e.g. '°C'.\r\n\r\nIf not set, the application environment needs to determine the displayable form.", 0, 1, units_display_name));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -2016783856: /*magnitude*/  return new Property("magnitude", "decimal", "Numeric magnitude of the quantity.", 0, 1, magnitude);
        case -1376177026: /*precision*/  return new Property("precision", "integer", "Precision to which the value of the quantity is expressed, in terms of number of decimal places. The value 0 implies an integral quantity. The value -1 implies no limit, i.e. any number of decimal places", 0, 1, precision);
        case 111433583: /*units*/  return new Property("units", "string", "Quantity units, expressed as a code or syntax string from either UCUM (the default) or the units system specified in units_system, when set.\r\n\r\nIn either case, the value is the code or syntax - normally formed of standard ASCII - which is in principal not the same as the display string, although in simple cases such as 'm' (for meters) it will be.\r\n\r\nIf the units_display_name field is set, this may be used for display. If not, the implementations must effect the resolution of the units value to a display form locally, e.g. by lookup of reference tables, request to a terminology service etc.\r\n\r\n\r\nExample values from UCUM: 'kg/m^2', 'mm[Hg]', 'ms-1', 'km/h'", 0, 1, units);
        case -162878209: /*units_system*/  return new Property("units_system", "string", "Optional field used to specify a units system from which codes in units are defined. Value is a URI identifying a terminology containing units concepts from the (HL7 FHIR terminologies list).\r\n\r\nIf not set, the UCUM standard (case-sensitive codes) is assumed as the units system.", 0, 1, units_system);
        case 359604920: /*units_display_name*/  return new Property("units_display_name", "string", "Optional field containing the displayable form of the units field, e.g. '°C'.\r\n\r\nIf not set, the application environment needs to determine the displayable form.", 0, 1, units_display_name);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -2016783856: /*magnitude*/ return this.magnitude == null ? new Base[0] : new Base[] {this.magnitude}; // DecimalType
        case -1376177026: /*precision*/ return this.precision == null ? new Base[0] : new Base[] {this.precision}; // IntegerType
        case 111433583: /*units*/ return this.units == null ? new Base[0] : new Base[] {this.units}; // StringType
        case -162878209: /*units_system*/ return this.units_system == null ? new Base[0] : new Base[] {this.units_system}; // StringType
        case 359604920: /*units_display_name*/ return this.units_display_name == null ? new Base[0] : new Base[] {this.units_display_name}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -2016783856: // magnitude
          this.magnitude = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case -1376177026: // precision
          this.precision = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 111433583: // units
          this.units = TypeConvertor.castToString(value); // StringType
          return value;
        case -162878209: // units_system
          this.units_system = TypeConvertor.castToString(value); // StringType
          return value;
        case 359604920: // units_display_name
          this.units_display_name = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("magnitude")) {
          this.magnitude = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("precision")) {
          this.precision = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("units")) {
          this.units = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("units_system")) {
          this.units_system = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("units_display_name")) {
          this.units_display_name = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -2016783856:  return getMagnitudeElement();
        case -1376177026:  return getPrecisionElement();
        case 111433583:  return getUnitsElement();
        case -162878209:  return getUnits_systemElement();
        case 359604920:  return getUnits_display_nameElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -2016783856: /*magnitude*/ return new String[] {"decimal"};
        case -1376177026: /*precision*/ return new String[] {"integer"};
        case 111433583: /*units*/ return new String[] {"string"};
        case -162878209: /*units_system*/ return new String[] {"string"};
        case 359604920: /*units_display_name*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("magnitude")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_QUANTITY.magnitude");
        }
        else if (name.equals("precision")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_QUANTITY.precision");
        }
        else if (name.equals("units")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_QUANTITY.units");
        }
        else if (name.equals("units_system")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_QUANTITY.units_system");
        }
        else if (name.equals("units_display_name")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_QUANTITY.units_display_name");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_QUANTITY";

  }

      public DV_QUANTITY copy() {
        DV_QUANTITY dst = new DV_QUANTITY();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DV_QUANTITY dst) {
        super.copyValues(dst);
        dst.magnitude = magnitude == null ? null : magnitude.copy();
        dst.precision = precision == null ? null : precision.copy();
        dst.units = units == null ? null : units.copy();
        dst.units_system = units_system == null ? null : units_system.copy();
        dst.units_display_name = units_display_name == null ? null : units_display_name.copy();
      }

      protected DV_QUANTITY typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_QUANTITY))
          return false;
        DV_QUANTITY o = (DV_QUANTITY) other_;
        return compareDeep(magnitude, o.magnitude, true) && compareDeep(precision, o.precision, true) && compareDeep(units, o.units, true)
           && compareDeep(units_system, o.units_system, true) && compareDeep(units_display_name, o.units_display_name, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_QUANTITY))
          return false;
        DV_QUANTITY o = (DV_QUANTITY) other_;
        return compareValues(magnitude, o.magnitude, true) && compareValues(precision, o.precision, true) && compareValues(units, o.units, true)
           && compareValues(units_system, o.units_system, true) && compareValues(units_display_name, o.units_display_name, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(magnitude, precision, units
          , units_system, units_display_name);
      }


}

