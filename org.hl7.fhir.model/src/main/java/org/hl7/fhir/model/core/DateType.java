package org.hl7.fhir.model.core;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */



import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.Base.CopyObjectOptions;
import org.hl7.fhir.model.Base;
import java.util.EnumSet;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import org.apache.commons.lang3.Validate;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Primitive type "date" in FHIR: any day in a gregorian calendar
 */

/**
 * Represents a FHIR date datatype. Valid precisions values for this type are:
 * <ul>
 * <li>{@link ca.uhn.fhir.model.api.TemporalPrecisionEnum#YEAR}
 * <li>{@link ca.uhn.fhir.model.api.TemporalPrecisionEnum#MONTH}
 * <li>{@link ca.uhn.fhir.model.api.TemporalPrecisionEnum#DAY}
 * </ul>
 */
@DatatypeDef(name = "date")
public class DateType extends BaseDateTimeType {

	private static final long serialVersionUID = 3L;
	
	/**
	 * The default precision for this type
	 */
	public static final TemporalPrecisionEnum DEFAULT_PRECISION = TemporalPrecisionEnum.DAY;

	/**
	 * Constructor
	 */
	public DateType() {
		super();
	}

	/**
	 * Constructor
	 *
	 * @param context the model context this object belongs to - all objects in a tree must share the same context
	 */
	public DateType(IModelContext modelContext) {
	  this();
	  this.modelContext = modelContext;
	}

	/**
	 * Constructor which accepts a date value and uses the {@link #DEFAULT_PRECISION} for this type
	 */
	public DateType(IModelContext modelContext, Date theDate) {
		super(modelContext, theDate, DEFAULT_PRECISION);
	}

	public DateType(Date theDate) {
	  this((IModelContext) null, theDate);
	}

	/**
	 * Constructor which accepts a date value and a precision value. Valid precisions values for this type are:
	 * <ul>
	 * <li>{@link ca.uhn.fhir.model.api.TemporalPrecisionEnum#YEAR}
	 * <li>{@link ca.uhn.fhir.model.api.TemporalPrecisionEnum#MONTH}
	 * <li>{@link ca.uhn.fhir.model.api.TemporalPrecisionEnum#DAY}
	 * </ul>
	 *
	 * @throws ca.uhn.fhir.parser.DataFormatException
	 *             If the specified precision is not allowed for this type
	 */
	public DateType(IModelContext modelContext, Date theDate, TemporalPrecisionEnum thePrecision) {
		super(modelContext, theDate, thePrecision);
	}

	public DateType(Date theDate, TemporalPrecisionEnum thePrecision) {
	  this((IModelContext) null, theDate, thePrecision);
	}

  /**
   * Constructor which accepts a date as a string in FHIR format
   *
   * @throws ca.uhn.fhir.parser.DataFormatException
   *             If the precision in the date string is not allowed for this type
   */
  public DateType(IModelContext modelContext, String theDate) {
    super(modelContext, theDate);
  }

  /**
   * Constructor which accepts a date as a string in FHIR format
   *
   * @throws ca.uhn.fhir.parser.DataFormatException
   *             If the precision in the date string is not allowed for this type
   */
  public DateType(String theDate) {
    super(theDate);
  }

	/**
	 * Constructor which accepts a date value and uses the {@link #DEFAULT_PRECISION} for this type.
	 */
	public DateType(IModelContext modelContext, Calendar theCalendar) {
		super(modelContext, theCalendar.getTime(), DEFAULT_PRECISION);
		setTimeZone(theCalendar.getTimeZone());
	}

	public DateType(Calendar theCalendar) {
	  this((IModelContext) null, theCalendar);
	}

	/**
	 * Constructor which accepts a date value and uses the {@link #DEFAULT_PRECISION} for this type.
	 * <p>
	 * <b>Use caution when using this constructor</b>: The month is 0-indexed but the day is 1-indexed 
	 * in order to match the bahaviour of the Java {@link Calendar} type.
	 * </p>
	 * 
	 * @param theYear The year, e.g. 2015
	 * @param theMonth The month, e.g. 0 for January
	 * @param theDay The day (1 indexed) e.g. 1 for the first day of the month
	 */
	public DateType(IModelContext modelContext, int theYear, int theMonth, int theDay) {
		this(modelContext, toCalendarZulu(theYear, theMonth, theDay));
	}

	public DateType(int theYear, int theMonth, int theDay) {
	  this((IModelContext) null, theYear, theMonth, theDay);
	}

	private static GregorianCalendar toCalendarZulu(int theYear, int theMonth, int theDay) {
		Validate.isTrue(theMonth >= 0, "theMonth must be between 0 and 11");
		Validate.isTrue(theMonth <= 11, "theMonth must be between 0 and 11");
		Validate.isTrue(theDay >= 1, "theDay must be between 1 and 31");
		Validate.isTrue(theDay <= 31, "theDay must be between 1 and 31");
		
		GregorianCalendar retVal = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
		retVal.set(Calendar.YEAR, theYear);
		retVal.set(Calendar.MONTH, theMonth);
		retVal.set(Calendar.DATE, theDay);
		return retVal;
	}

	@Override
	boolean isPrecisionAllowed(TemporalPrecisionEnum thePrecision) {
		switch (thePrecision) {
			case YEAR:
			case MONTH:
			case DAY:
				return true;
			default:
				return false;
		}
	}

	/**
	 * Returns the default precision for this datatype
	 *
	 * @see #DEFAULT_PRECISION
	 */
	@Override
	protected TemporalPrecisionEnum getDefaultPrecisionForDatatype() {
		return DEFAULT_PRECISION;
	}

	@Override
	public DateType copy(EnumSet<CopyObjectOptions> options) {
		DateType ret = new DateType(modelContext, getValueAsString());
    copyValues(ret, options);
    return ret;
	}
	
	public static InstantType today() {
		return new InstantType(new Date(), TemporalPrecisionEnum.DAY, TimeZone.getDefault());
	}

	/**
	 * Creates a new instance by parsing an HL7 v3 format date time string
	 */
	public static DateType parseV3(String theV3String) {
		DateType retVal = new DateType();
		retVal.setValueAsV3String(theV3String);
		return retVal;
	}

	@Override
	public String fhirType() {
		return "date";		
	}

  @Override
  public boolean isDateTime() {
    return true;
  }
}